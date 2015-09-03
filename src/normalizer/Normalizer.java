/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package normalizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artur
 */
public class Normalizer {
    
    private static final String PATH_TO_BOOKS = "pathToBooks";
    private static final String PATH_TO_WORD_NET_DICT = "pathToWordNetDict";
    private static final String PATH_TO_STAR_DICT = "pathToStarDict";
    private static final String PATH_TO_RESULT = "pathToResult";
    private static final String COUNT_WORD = "countWord";
    
    private static final String PATH_TO_SETTINGS = "./config/settings.ini";

    private static Properties props = new Properties();
    private static String pathToBooks;
    private static String pathToWordNetDict;
    private static String pathToStarDict;
    private static String pathToResult;
    private static int countWord;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            props.load(new FileInputStream(new File(PATH_TO_SETTINGS)));
        } catch (IOException ex) {
            Logger.getLogger(Normalizer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pathToBooks = props.getProperty(PATH_TO_BOOKS);
        pathToWordNetDict = props.getProperty(PATH_TO_WORD_NET_DICT);
        pathToStarDict = props.getProperty(PATH_TO_STAR_DICT);
        pathToResult = props.getProperty(PATH_TO_RESULT);
        countWord = Integer.valueOf(props.getProperty(COUNT_WORD));
        
        System.out.println(pathToBooks);
        System.out.println(pathToWordNetDict);
        System.out.println(pathToStarDict);
        System.out.println(pathToResult);
        System.out.println(countWord);

    }
    
}
