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
public class TestNoun {
    public static void main(String[] args) {
        WordNetVerb wnn = new WordNetVerb();
        if(wnn.initialize("./wordnet/dict/")) {
            System.out.println("Ок!");
            String[] mas = {"are", "were", "has", "draws", "runs", "came", "have"};
            for(String s : mas) {
                System.out.println(wnn.getLemma(s));
            }
        }
        
    }
}
