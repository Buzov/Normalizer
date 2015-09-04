
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author artur
 */
public class FileSize {
    public static void main(String[] args) {
        File file = new File("./books/test.txt");
        System.out.println(file.length());
    }
}
