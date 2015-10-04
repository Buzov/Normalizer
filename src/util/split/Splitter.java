package util.split;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author RT
 */
public class Splitter {

    /**
     * Переменная с кодировкой
     */
    protected static final String ENCODING = "utf-8";
    /**
     * Расширение файла
     */
    private static final String[] EXP = {".txt", ".srt"};
    /**
     * Шаблон
     */
    private static final String REGEX = "((?:[a-zA-Z]+[-']?)*[a-zA-Z]+)";
    private static Pattern p = Pattern.compile(REGEX);
    Matcher m = null;
    private File directory = null;
    private static List<String> listPathToBooks = null;
    private static List<String> listWords = null;

    public boolean initialize(String pathToBooks) {
        return initialize(pathToBooks, ENCODING);
    }

    public boolean initialize(String pathToBooks, String encoding) {

        directory = new File(pathToBooks);
        if (!directory.exists() || !directory.isDirectory()) {
            return false;
        }
        listPathToBooks = getListPathToBooks();
        if (listPathToBooks == null || listPathToBooks.isEmpty()) {
            return false;
        }
        try {
            listWords = splitt();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        ComparatorByValue cmp = new ComparatorByValue();
        Map<String, Integer> map = new HashMap<>();
        for (String s : listWords) {
            //System.out.println(s);
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        Set<Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(WorkbookUtil.createSafeSheetName("words"));
        int i = 0;
        for (Map.Entry<String, Integer> entry : list) {
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(entry.getKey());
            row.createCell(1).setCellValue(entry.getValue().toString());
            System.out.println(entry.getKey() + " ==== " + entry.getValue());
            i++;
        }
        String path = "/Users/artur/Desktop/Harry/harry_words.xlsx";

        try (FileOutputStream fs = new FileOutputStream(path)) {
            workbook.write(fs);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            workbook.close();
        } catch (IOException ex) {
            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*for(Entry e : map.entrySet()) {
         System.out.println("word = " + e.getKey() + " count = " + e.getValue());
         }*/
        System.out.println("size = " + listWords.size());
        return true;
    }

    private List<String> getListPathToBooks() {
        List<String> list = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                String path = file.getPath();
                for (String s : EXP) {
                    if (path.endsWith(s)) {
                        list.add(path);
                        break;
                    }
                }
            }
        }
        return list;
    }

    private List<String> splitt() throws UnsupportedEncodingException, FileNotFoundException, IOException {
        List<String> list = new ArrayList<>();
        
        for (String path : listPathToBooks) {

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(new File(path)), ENCODING)
            );
            String line;

            while ((line = br.readLine()) != null) {

                m = p.matcher(line);
                while (m.find()) {
                    list.add(m.group().toLowerCase());
                }
            }
            br.close();
        }
        return list;
    }

    private static List<String> splitt(String s) {
        List<String> list = new ArrayList<>();
        Matcher m = p.matcher(s);
        while (m.find()) {
            list.add(m.group().toLowerCase());
        }
        return list;
    }
    
    private static List<String> splitt(String s, String regex) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            list.add(matcher.group().toLowerCase());
        }
        return list;
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
