package split;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private static final String EXP = ".txt";
    /**
     * Шаблон
     */
    private static final String REGEX = "((?:[a-zA-Z]+[-']?)*[a-zA-Z]+)";
    Pattern p = Pattern.compile(REGEX);
    Matcher m = null; 
    private File directory = null;
    private static List<String> listPathToBooks = null;
    private static List<String> listWords = null;
    
    public boolean initialize(String pathToBooks) {
        return initialize(pathToBooks, ENCODING);
    }
    
    public boolean initialize(String pathToBooks, String encoding) {
        
        directory = new File(pathToBooks);
        if(!directory.exists() || !directory.isDirectory()) {
            return false;
        }
        listPathToBooks = getListPathToBooks();
        if(listPathToBooks == null || listPathToBooks.isEmpty()) {
            return false;
        }
        try {
            listWords = splitt();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(String s : listWords) {
            System.out.println(s);
        }
        return true;
    }
    
    private List<String> getListPathToBooks() {
        List<String> list = new ArrayList<>();
        for(File file : directory.listFiles()) {
            if(file.isFile()) {
                String path = file.getPath();
                if(path.endsWith(EXP)) {
                    list.add(path);
                }
            }
        }
        return list;
    }
    
    private List<String> splitt() throws UnsupportedEncodingException, FileNotFoundException, IOException {
        List<String> list = new ArrayList<>();              
        for(String path : listPathToBooks) {
            BufferedReader br = new BufferedReader (
                new InputStreamReader(
                        new FileInputStream(new File(path)), ENCODING)
            );
            String line = null;
            while ((line = br.readLine()) != null) {
                m = p.matcher(line);
                while (m.find()) {
                    list.add(m.group());
                }
            }
            br.close();
        }
        return list;
    }
    
    public static void main(String[] args) {
        new Splitter().initialize("./books/");
    }
    
}
