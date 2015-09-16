package wordNet;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для работы с нормализацией существительных
 * Класс наследуется от BaseWordNetItem
 * @author RT
 */
public class WordNetNoun extends BaseWordNetItem {
    
    /**
     * Правила замены окончаний при нормализации слова по правилам. 
     * К примеру, окончание "s" заменяется на "", "ses" заменяется на "s" и тд.
     */
    private static final Map<String, String> mapRule = new HashMap<>();
    static {
        mapRule.put("s", "");
        mapRule.put("’s", "");
        mapRule.put("’", "");
        mapRule.put("ses", "s");
        mapRule.put("xes", "x");
        mapRule.put("zes", "z");
        mapRule.put("ches", "ch");
        mapRule.put("shes", "sh");
        mapRule.put("men", "man");
        mapRule.put("ies", "y");
    }
    private static final String EXC = "noun.exc";
    private static final String INDEX = "index.noun";
    
    @Override
    protected Map<String, String> getMapRule() {
        return mapRule;
    }
    
    @Override
    protected String getExc() {
        return EXC;
    }

    @Override
    protected String getIndex() {
        return INDEX;
    }
    
    /*

        
        
        
                    
                    
    # Метод возвращает лемму сушествительного(нормализованную форму слова)
    # Этот метод есть в базовом классе BaseWordNetItem, но нормализация существительных несколько отличается от нормализации других частей речи, 
    # поэтому метод в наследнике переопределен
    def GetLemma(self, word):	
        
        word = word.strip().lower() 
        
        # Если существительное слишком короткое, то к нормализованному виду мы его не приводим	
        if len(word) <= 2:
            return None	

        # Если существительное заканчивается на "ss", то к нормализованному виду мы его не приводим	
        if word.endswith("ss"):
            return None	
            
        # Пройдемся по кэшу, возможно слово уже нормализовывалось раньше и результат сохранился в кэше
        lemma = self._GetDictValue(self.cacheWords, word)
        if lemma != None:
            return lemma
            
        # Проверим, если слово уже в нормализованном виде, вернем его же
        if self._IsDefined(word):
            return word
        
        # Пройдемся по исключениям, если слово из исключений, вернем его нормализованную форму
        lemma = self._GetDictValue(self.wordNetExcDict, word)
        if (lemma != None):
            return lemma

            
        # Если существительное заканчивается на "ful", значит отбрасываем "ful", нормализуем оставшееся слово, а потом суффикс приклеиваем назад.
        # Таким образом, к примеру, из слова "spoonsful" после нормализации получится "spoonful"
        suff = ""
        if word.endswith("ful"): 
                word = word[:-3] # Отрезаем суффикс "ful"
                suff = "ful" # Отрезаем суффикс "ful", чтобы потом приклеить назад
        
        
        # На этом шаге понимаем, что слово не является исключением и оно не нормализовано, значит начинаем нормализовывать его по правилам. 
        lemma = self._RuleNormalization(word)
        if (lemma != None):
            lemma += suff # Не забываем добавить суффикс "ful", если он был
            self.cacheWords[word] = lemma # Предварительно добавим нормализованное слово в кэш
            return lemma		

        return None	
    */
}
