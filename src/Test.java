
import java.io.File;
import startDict.BaseStarDictItem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author artur
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String s = "d+d";
        String[] ss = s.split("-");
        for(String d: ss) {
            System.out.println(d);
        }
        System.out.println(String.join("-", ss));
        
        File f = new File("./stardict");
        for(String sd : f.list()) {
            System.out.println(sd);
            System.out.println(sd.endsWith("idx"));
        }
        ;
        
    }
}
