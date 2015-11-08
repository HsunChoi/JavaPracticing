package com.xun.java.practing.practice;

import java.util.Scanner;

/**
 * Created by cuixun on 2/24/15.
 */
public class StringCompression {
    public static void main(String[] args) {
        System.out.println("Please enter a String: ");
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        System.out.println(stringCompress(str));


    }

    public static String stringCompress(String str) {
        int val = countString(str);
        System.out.println(val);
        if(str.length() < val){
            return str;
        }
        char lastChar = str.charAt(0);
        int count = 1;
        //String mystr = ""; //bad methods
        StringBuffer mystr = new StringBuffer();    // Better;
        for (int i = 1; i < str.length(); i++) {
            if (lastChar == str.charAt(i)) {
                count++;
            } else {
                //mystr += lastChar + "" + count;
                //mystr += lastChar + count;
                //mystr = mystr + lastChar + count;
                mystr.append(lastChar).append(count);
                lastChar = str.charAt(i);
                count = 1;
            }

        }
        mystr.append(lastChar).append(count);
        String result = new String(mystr);
        return result;

    }

    public static int countString(String str) {
        if (str.isEmpty() || str == null) {
            return 0;
        }
        int count = 0;
        int charCount = 1;
        char lastChar = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (lastChar == str.charAt(i)) {
                charCount++;
            } else {
                lastChar = str.charAt(i);
                count += 1 + String.valueOf(charCount).length();
            }
        }
        count += 1 + String.valueOf(charCount).length();

        return count;
    }
}
