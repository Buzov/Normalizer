/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;

/**
 *
 * @author artur
 */

public class Sha {
    
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String s = "password";
        System.out.println("Строка = " + s);
        System.out.println("SHA-256 = " + hash256(s));
        
        /*MessageDigest md = MessageDigest.getInstance( "SHA-512" );
        md.update(s.getBytes("UTF-8"));
        byte[] aMessageDigest = md.digest();

        String outEncoded = Base64.getEncoder().encodeToString( aMessageDigest );
        System.out.println(outEncoded);*/
        
        // 5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8
        // 5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8
    }
    
    public static String hash256(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return bytesToHex(md.digest());
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
}
