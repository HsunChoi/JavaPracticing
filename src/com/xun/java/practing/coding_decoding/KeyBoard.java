package com.xun.java.practing.coding_decoding;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cuixun on 11/11/15.
 */
public class KeyBoard {
    static String laptopKeyboard = "qwertyuiopasdfghjklzxcvbnm";
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static String[] nokiaPhoneBoard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
            "tuv", "wxyz"};



    public static Map<Character, Character> getCodingMap(){
        Map map = new HashMap<Character, Character>();
        for(int i = 0; i < laptopKeyboard.length(); i++){
            map.put(alphabet.charAt(i), laptopKeyboard.charAt(i));
        }
        return map;
    }

    public static Map<Character, Character> getDecodingMap(){
        Map map = new HashMap<Character, Character>();
        for(int i = 0; i < laptopKeyboard.length(); i++){
            map.put(laptopKeyboard.charAt(i), alphabet.charAt(i));
        }
        return map;
    }

    public static Map<Character, Integer> getNokiaCodingMap(){
        Map map = new HashMap<Character, Integer>();
        for(int i = 0; i < nokiaPhoneBoard.length; i++){
            int x = i * 10;
            String s = nokiaPhoneBoard[i];
            for(int j = 0; j < s.length(); j++){
                Character c = s.charAt(j);
                int num = x + j + 1;
                map.put(c, num);
            }
        }

        return map;
    }

    public static Map<String, Character> getNokiaDecodingMap(){
        Map map = new HashMap<String, Character>();
        for(int i = 0; i < nokiaPhoneBoard.length; i++){
            int x = i * 10;
            String s = nokiaPhoneBoard[i];
            for(int j = 0; j < s.length(); j++){
                Character c = s.charAt(j);
                int num = x + j + 1;

                map.put(Integer.toString(num), c);
            }
        }

        return map;
    }


}
