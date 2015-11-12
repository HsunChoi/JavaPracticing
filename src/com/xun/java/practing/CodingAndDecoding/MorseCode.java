package com.xun.java.practing.CodingAndDecoding;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cuixun on 11/11/15.
 */
public class MorseCode {
    static String[] numMorse = {"-----", "*----", "**---", "***--", "****-", "****",
            "-****", "--***", "---**", "----*"};


    public static Map<Character, String>getMorseMap(){
        Map map = new HashMap<>();
        for(int i = 0; i < numMorse.length; i++){
            Character c = Integer.toString(i).charAt(0);
            map.put(c, numMorse[i]);
        }


        return map;
    }

    public static Map<String, Character> getMorseDecodingMap(){
        Map<String, Character> map = new HashMap<String, Character>();
        for(int i = 0; i < numMorse.length; i++){
            Character c = Integer.toString(i).charAt(0);
            map.put(numMorse[i], c);
        }


        return map;
    }
}
