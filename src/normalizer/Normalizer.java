package normalizer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import startDict.StartDict;

/**
 * http://habrahabr.ru/post/161073/
 * @author RT
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
    
    private static String[] listPathToStarDict = null;
    private static List<StartDict> listLanguageDict = new ArrayList<>();
    private static String[] listBooks = null;
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
        
        // Отделяем пути словарей StarDict. Все пути заносим в список listPathToStarDict
        listPathToStarDict = new File(pathToStarDict).list();

        // Для каждого из путей до словарей StarDict создаем свой языковый словарь
        for(String dict : listPathToStarDict) {
            //listLanguageDict.add(new StartDict(dict));
        }
        
        // Получаем список книг, из которых будем получать слова
        listBooks = new File(pathToBooks).list();
            /*self.listBooks = self.__GetAllFiles(self.pathToBooks)/*

        // Создаем частотный словарь		
            /*self.frequencyDict = FrequencyDict(self.pathToWordNetDict)	*/		
    
        // Подготовка закончена, загружены словари StarDict и WordNet. Запускаем задачу на выполнение, то есть начинаем парсить текстовые файл, нормализовывать и считать слова			
        run();

    }
    
    // Метод запускает задачу на выполнение
    private static void run() {
        // Отдаем частотному словарю по одной книге	
		/*for book in self.listBooks:
			self.frequencyDict.ParseBook(book)	*/	
			
	// Получаем первые countWord слов из всего получившегося списка английских слов			
		/*mostCommonElements = self.frequencyDict.FindMostCommonElements(self.countWord)
		
	// Получаем переводы для всех слов
		for item in mostCommonElements:
			word = item[0]
			counterWord = item[1]
			valueWord = getTranslate(word);
			self.result.append([counterWord, word, valueWord])	*/

	// Запишем результат в файл формата Excel 
	saveResultToExcel();		
    }
    
    // Метод сохраняет результат(само слово, частота, его перевод) по первым countWord словам в файл формата Excel
    private static void saveResultToExcel() {
        
    }
    
    // Метод бежит по всем словарям, и возвращает перевод из ближайшего словаря. 
    // Если перевода нет ни в одном из словарей, возвращается пустая строка
    private static String  getTranslate() {
        return null;
    }
    
    // Метод создает список файлов, расположенных в папке path	
    private static void getAllFiles(String path) {
        
    }
    
}
