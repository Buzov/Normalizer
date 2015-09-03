package startDict;

import java.io.RandomAccessFile;

/**
 * http://strongexperts.narod.ru/ru/articles/archive/java2/2006/may2006-001/may2006-001.htm
 * http://strongexperts.narod.ru/ru/articles/archive/java2/2007/feb2007-001/feb2007-001.htm
 * http://habrahabr.ru/post/108076/
 * http://khpi-iip.mipk.kharkiv.edu/library/extent/prog/inter/string.html
 * @author RT
 */
public class StartDict extends BaseStarDictItem {
    
    private static final String EXTENSION = "dict";
    private static final String MODE = "rw";
    
     /**
      * Маркер, определяющий форматирование словарной статьи
      */
    private String sameTypeSequence = null;
    
    private RandomAccessFile raf = null;

    // Маркер может быть составным (к примеру, sametypesequence = tm).
    // Виды одно-символьныx идентификаторов  словарных статей (для всех строчных идентификаторов текст в формате utf-8, заканчивается '\0'):
    // 'm' - просто текст в кодировке utf-8, заканчивается '\0' 
    // 'l' - просто текст в НЕ в кодировке utf-8, заканчивается '\0' 
    // 'g' - текст размечен с помощью языка разметки текста Pango
    // 't' - транскрипция в кодировке utf-8, заканчивается '\0' 
    // 'x' - текст в кодировке utf-8, размечен с помощью xdxf
    // 'y' - текст в кодировке utf-8, содержит китайские(YinBiao) или японские (KANA) символы 
    // 'k' - текст в кодировке utf-8, размечен с помощью  KingSoft PowerWord XML 
    // 'w' - текст размечен с помощью  MediaWiki
    // 'h' - текст размечен с помощью  Html
    // 'n' - текст размечен формате для WordNet
    // 'r' - текст содержит список ресурсов. Ресурсами могут быть файлы картинки (jpg), звуковые (wav), видео (avi), вложенные(bin) файлы и др.
    // 'W' - wav файл
    // 'P' - картинка
    // 'X' - этот тип зарезервирован для экспериментальных расширений
    

    public StartDict(String pathToDict, String sameTypeSequence) throws Exception {
        super(pathToDict, EXTENSION);
        this.sameTypeSequence = sameTypeSequence;
        System.out.println(pathToFile);
        raf = new RandomAccessFile(pathToFile, MODE);
    }
    
    public String getTranslation(int wordDataOffset, int wordDataSize) throws Exception {
        checkValidArguments(wordDataOffset, wordDataSize);
        byte[] byteArray = new byte[wordDataSize+10];
        // Читаем часть файла, относящегося к переводу слова
        raf.seek(wordDataOffset);
        raf.read(byteArray, wordDataOffset, wordDataSize);
        // Вернем раскодированный в юникодную строку набор байтoв 
        // (self.encoding определен в базовом классе BaseDictionaryItem)
        return new String(byteArray, "UTF-8");
    }
            
    private boolean checkValidArguments(int wordDataOffset, int wordDataSize) throws Exception {
        int endDataSize = wordDataOffset + wordDataSize;
        int realFileSize = 10000;
        if((wordDataOffset < 0) || (wordDataSize < 0) || (endDataSize > realFileSize)) {
            throw new Exception();
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        StartDict sd = new StartDict("./stardict", "");
        System.out.println(sd.getTranslation(100, 50));
    }
}
