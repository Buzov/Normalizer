
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author artur
 */
public class NewClass {
    public static void main(String[] args) {
        int a = 127;
        Integer i1 = a;
        Integer i2 = a;
        String s = "Мама";
        System.out.println(new Integer(a) == new Integer(a));
        System.out.println(Objects.equals(i1, i2));
        System.out.println(i1.equals(i2));
        System.out.println("Мама".equals(s));
    }
}
