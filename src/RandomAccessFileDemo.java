
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author artur
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) {
      try {
         byte[] b1 = {-10, -10, -10};
         byte[] b2 = {-10, -10, -10};

         // create a new RandomAccessFile with filename test
         RandomAccessFile raf = new RandomAccessFile("./books/test.txt", "rw");

         // write something in the file
         raf.writeUTF("Hello World");

         // set the file pointer at 0 position
         raf.seek(0);

         // read 2 bytes, starting from 1
         System.out.println("" + raf.read(b1, 1, 2));
         System.out.println("--------------------");
         for(byte b : b1) {
             System.out.println(b);
         }
          System.out.println("--------------------");
         // set the file pointer at 0 position
         raf.seek(4);

         // read 3 bytes, starting from 4rth
         System.out.println("" + raf.read(b2, 0, 3));
         System.out.println("--------------------");
         for(byte b : b2) {
             System.out.println(b);
         }
      } catch (IOException ex) {
         ex.printStackTrace();
      }

   }
}
