package wordNet;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для нормализации глаголов
 * Класс наследуется от BaseWordNetItem
 * @author RT
 */
public class WordNetVerb extends BaseWordNetItem {
    
    /**
     * Правила замены окончаний при нормализации слова по правилам. 
     * К примеру, окончание "s" заменяется на "" , "ies" на и "y" тд.
     */
    private static final Map<String, String> mapRule = new HashMap<>();
    static {
        mapRule.put("s", "");
        mapRule.put("ies" , "y");
        mapRule.put("es", "e");
        mapRule.put("es", "");
        mapRule.put("ed", "e");
        mapRule.put("ed", "");
        mapRule.put("ing", "e");
        mapRule.put("ing", "");	
    }
    private static final String EXC = "verb.exc";
    private static final String INDEX = "index.verb";

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
        
    // Метод получения нормализованной формы слова GetLemma(word) 
    // определен в базовом классе BaseWordNetItem
}
