/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordNet;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author artur
 */
public class Test {
    public static void main(String[] args) {
        
        Map<String, String> mapRule = new HashMap<>();
        mapRule.put("s", "");
        mapRule.put("ed", "");
        mapRule.put("ing", "");
        
        String[] s = {"runs", "bring", "studed"};
        
        String word = "runs";
        for(String ss : s) {
            for(Map.Entry<String, String> e : mapRule.entrySet()) {
                if(ss.endsWith(e.getKey())) {
                    int pos = ss.lastIndexOf(e.getKey());
                    String lemma = ss.substring(0, pos);
                    System.out.println("lemma = " + lemma);
                    break;
                }
            }
        }
        
    }
}
