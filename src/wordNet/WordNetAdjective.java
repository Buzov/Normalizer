package wordNet;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для работы с нормализацией прилагательных
 * Класс наследуется от BaseWordNetItem
 * @author RT
 */
public class WordNetAdjective extends BaseWordNetItem {
    
    /**
     * Правила замены окончаний при нормализации слова по правилам. 
     * К примеру, окончание "er" заменяется на "" или  "e" и тд.
     */
    private static final Map<String, String> mapRule = new HashMap<>();
    static {
        mapRule.put("er", "");
        mapRule.put("er", "e");
        mapRule.put("er", "e");
        mapRule.put("est", "e");
    }
    private static final String EXC = "adj.exc";
    private static final String INDEX = "index.adj";

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
