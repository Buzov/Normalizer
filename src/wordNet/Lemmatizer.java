/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordNet;

/**
 *
 * @author artur
 */
public class Lemmatizer {
    
    /**
     * Разделитель составных слов	
     */
    private static final String splitter = "-"; 		
    
    private WordNetAdjective adj; 
    private WordNetNoun noun;
    private WordNetAdverb adverb;
    private WordNetVerb verb;
    
    private BaseWordNetItem[] wordNet = {adj, noun, adverb, verb};
           
    
    public Lemmatizer(String pathToWordNetDict) {
        // Инициализируем объекты с частям речи
        adj = new WordNetAdjective(pathToWordNetDict);	// Прилагательные
        noun = new WordNetNoun(pathToWordNetDict);	// Существительные
        adverb = new WordNetAdverb(pathToWordNetDict);	// Наречия
        verb = new WordNetVerb(pathToWordNetDict);      // Глаголы
    }
    
    /**
     * Метод возвращает лемму слова (возможно, составного)
     * @param word Слово, которое нужно нормализовать, может быть следующего вида - 't-shirt'
     * @return 
     */
    public String getLemma(String word) {
        // Если в слове есть тире, разделим слово на части, нормализуем 
        // каждую часть(каждое слово) по отдельности, а потом соединим
        String[] words = word.split(splitter);
        String lemma = null;
        for(int i = 0; i < words.length; i++) {
            lemma = getLemmaWord(words[i]);
            if(lemma != null) {
                words[i] = lemma;
            }
        }
        return String.join(splitter, words);
    }
    
    /**
     * Метод возвращает лемму(нормализованную форму слова)
     * @param word - Слово, которое нужно нормализовать
     * @return Нормализованная форма слова
     */           
    private String getLemmaWord(String word) {
        for(int i = 0; i < wordNet.length; i++) {
            String lemma = wordNet[i].getLemma(word);
            if(lemma != null) {
                return lemma;
            }
        }
        return null; 
    }
    
    
}
