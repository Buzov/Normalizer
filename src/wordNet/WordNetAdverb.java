package wordNet;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для нормалзации наречий
 * Класс наследуется от BaseWordNetItem
 * @author RT
 */
public class WordNetAdverb extends BaseWordNetItem {
    
     /**
     * Правила замены окончаний при нормализации слова по правилам.
     * У наречий есть только списки исключений(adv.exc) и итоговый список слов(index.adv).	
     * Правила замены окончаний при нормализации слова по правилам у наречий нет. 
     */
    private static final Map<String, String> mapRule = new HashMap<>();
    private static final String EXC = "adv.exc";
    private static final String INDEX = "index.adv";


        
    // Метод получения нормализованной формы слова GetLemma(word) 
    // определен в базовом классе BaseWordNetItem
    
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
}
