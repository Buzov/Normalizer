
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author artur
 */
public class DemoRegular1 {

    public static void main(String[] args) {

// поиск и выбор подстроки, заданной шаблоном
        
        String s = "Hello World dog good god cat pat car_re f@ly bye; dog-fly";
        Pattern p2 = Pattern.compile(regex);
        Matcher m2 = p2.matcher(s);
        while (m2.find()) {
            System.out.println("e-mail: " + m2.group());
        }
// разбиение строки на подстроки с применением шаблона в качестве
// разделителя
        Pattern p3 = Pattern.compile("\\d+\\s?");
        String[] words = p3.split("java5tiger 77 java6mustang");
        for (String word : words) {
            System.out.println(word);
        }
    }
}

