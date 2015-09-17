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
public class TestLemma {
    public static void main(String[] args) {
        String[] mas = {"are", "were", "has", "draws", "runs", "came", "have", "broken", "I", "You", "dogs", "powersful", "drivers", "men", "women", "women-have", "not"};
        Lemmatizer l = new Lemmatizer("./wordnet/dict/");
        
            if(l.isInit()) {
                for(String s : mas) {
                    System.out.println(l.getLemma(s));
                }
            }

        }
}
