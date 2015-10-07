package util.split;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static util.file.Lister.getFilesList;

/**
 *
 * @author RT
 */
public class Splitter {

    private static final String ENTER = "\n";
    /**
     * Расширение файла
     */
    private static final String[] EXP = {".txt", ".srt"};
    /**
     * Переменная с кодировкой
     */
    protected static final String ENCODING = "utf-8";
    /**
     * Шаблон
     */
    private static final String REGEX = "((?:[a-zA-Z]+[-']?)*[a-zA-Z]+)";
    private static final Pattern p = Pattern.compile(REGEX);
    
//    public List<String> initialize(String pathToBooks, String encoding) throws IOException {
//
//        List<File> list = getFilesList(pathToBooks, EXP);
//        List<String> listWords = splitt();
//
//        ComparatorByValue cmp = new ComparatorByValue();
//        Map<String, Integer> map = new HashMap<>();
//        for (String s : listWords) {
//            //System.out.println(s);
//            if (map.containsKey(s)) {
//                map.put(s, map.get(s) + 1);
//            } else {
//                map.put(s, 1);
//            }
//        }
//        Set<Entry<String, Integer>> set = map.entrySet();
//        List<Entry<String, Integer>> list = new ArrayList<>(set);
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return (o2.getValue()).compareTo(o1.getValue());
//            }
//        });
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet(WorkbookUtil.createSafeSheetName("words"));
//        int i = 0;
//        for (Map.Entry<String, Integer> entry : list) {
//            Row row = sheet.createRow(i);
//            row.createCell(0).setCellValue(entry.getKey());
//            row.createCell(1).setCellValue(entry.getValue().toString());
//            System.out.println(entry.getKey() + " ==== " + entry.getValue());
//            i++;
//        }
//        String path = "/Users/artur/Desktop/Harry/harry_words.xlsx";
//
//        try (FileOutputStream fs = new FileOutputStream(path)) {
//            workbook.write(fs);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            workbook.close();
//        } catch (IOException ex) {
//            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        /*for(Entry e : map.entrySet()) {
//         System.out.println("word = " + e.getKey() + " count = " + e.getValue());
//         }*/
//        System.out.println("size = " + listWords.size());
//        return true;
//    }
//    
    private static List<String> splitt(String pathToBooks, String encoding, String[] exp) throws IOException {
        List<File> listFiles = getFilesList(pathToBooks, exp);
        List<String> list = new LinkedList<>();
        for (File file : listFiles) {
            try (FileInputStream fis = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fis, encoding);
                    BufferedReader br = new BufferedReader(isr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    Matcher m = p.matcher(line);
                    while (m.find()) {
                        list.add(m.group().toLowerCase());
                    }
                }
            }
        }
        return list;
    }
    
    /**
     * Возвращает объедененную строку из содержимого текстовых файлов.
     * 
     * @param pathToBooks Путь к тестовым файлам
     * @param encoding Кодировка текстовых файлов
     * @param exp Массив с расширениями фалов
     * @return Содержимое фалов в виде строки
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует 
     */
    private static String getStringFromFiles(String pathToBooks, String encoding, String[] exp) throws IOException {
        List<File> listFiles = getFilesList(pathToBooks, exp);
        StringBuilder sb = new StringBuilder();
        for (File file : listFiles) {
            try (FileInputStream fis = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fis, encoding);
                    BufferedReader br = new BufferedReader(isr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append(ENTER);
                }
            }
        }
        return sb.toString();
    }  

//    private static List<String> splitt(String pathToBooks) throws IOException, IOException {
//        return splitt(pathToBooks, ENCODING, EXP);
//    }

    /**
     * Метод возвращает лист слов из переданной строки
     * 
     * @param words Строка со словами
     * @return Лист слов из переданной строки
     */
    private static List<String> splittUtil(String words) {
        return splittUtil(words, REGEX);
    }

    /**
     * Метод возвращает лист слов из переданной строки. Разбиение строки будет 
     * производиться по указанному регулярному выражению.
     * 
     * @param words Строка со словами
     * @param regex Регулярное выражение
     * @return Лист слов из переданной строки
     */
    private static List<String> splittUtil(String words, String regex) {
        List<String> list = new LinkedList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(words);
        while (matcher.find()) {
            list.add(matcher.group().toLowerCase());
        }
        return list;
    }
    
    /**
     * Метод вызвращает лист слов из текстовых файлов, которые расположены в 
     * указанном пути.
     * Файлы должны быть в корировке utf-8.
     * 
     * @param pathToBooks Путь к тектовым файлам
     * @return Лист слов из текстовых фалов
     * @throws IOException Выбрасывает исключение если указанный путь не
     * существует
     */
    public static List<String> splitt(String pathToBooks) throws IOException {
        String s = getStringFromFiles(pathToBooks, ENCODING, EXP);
        return splittUtil(s);
    }
    
    public static void main(String[] args) throws IOException {
        for (String string : splitt("./books")) {
            System.out.println(string);
        }
    }

}

class ComparatorByValue implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        if (e1.getValue() < e2.getValue()) {
            return 1;
        } else if (Objects.equals(e1.getValue(), e2.getValue())) {
            return 0;
        } else {
            return -1;
        }
    }
}
