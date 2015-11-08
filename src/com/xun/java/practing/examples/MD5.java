package com.xun.java.practing.examples;

import java.security.*;
import java.util.Scanner;

/**
 * Created by cuixun on 4/10/15.
 */
public class MD5 {
    public static void main(String[]args){



        Scanner cin = new Scanner(System.in);
        System.out.println("Please your string: ");
        String password = cin.nextLine();

       try {
           MessageDigest md = MessageDigest.getInstance("MD5");
           md.update(password.getBytes());

           byte[] byteData = md.digest();

           for(int i = 0; i < byteData.length; i++){
               System.out.print(byteData[i]);
           }
           System.out.println();

           //convert the byte to hex format method 1
           StringBuffer sb = new StringBuffer();
           for (int i = 0; i < byteData.length; i++) {
               sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
           }

           System.out.println("Digest(in hex format):: " + sb.toString());

           //convert the byte to hex format method 2
           StringBuffer hexString = new StringBuffer();
           for (int i = 0; i < byteData.length; i++) {
               String hex = Integer.toHexString(0xff & byteData[i]);
               if (hex.length() == 1){
                   hexString.append('0');
               }
               hexString.append(hex);
           }
           System.out.println("Digest(in hex format):: " + hexString.toString());
       }
       catch(NoSuchAlgorithmException e){

       }
    }


}
