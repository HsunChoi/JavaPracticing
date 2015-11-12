package com.xun.java.practing.coding_decoding;

/**
 * Created by cuixun on 11/11/15.
 */
public class RailFenceCipher {

    public static String railFenceCipherCoding(String s){
        String result;

        String left = "";
        String right = "";
        for(int i = 0; i < s.length(); i += 2){
            left = left + s.charAt(i);
        }
        for(int i = 1; i < s.length(); i += 2){
            right = right + s.charAt(i);
        }
        result = left + right;

        return result;
    }

    public static String railFenceCipherDecoding(String s){
        String result = "";
        if(s.length() % 2 == 0){
            int mid = s.length() / 2;
            int x = mid;
            for(int i = 0; i < mid; i++){
                result = result + s.charAt(i);
                result = result + s.charAt(x);
                x++;
            }
        }else{
            int mid = s.length() / 2;
            int x = mid;
            for(int i = 0; i < mid; i++){
                result = result + s.charAt(i);
                result = result + s.charAt(x + 1);
                x++;
            }
            result = result + s.charAt(mid);
        }
        return result;
    }
}
