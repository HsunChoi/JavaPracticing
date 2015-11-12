package com.xun.java.practing.CodingAndDecoding;

import java.util.Map;

/**
 * Created by cuixun on 11/11/15.
 * Idea and Reference from importnew.
 */
public class Coding {
    public static String romaCoding(String s){
        /**
         * Initialization: use lower case and remove all the spaces
         */
        s = s.toLowerCase().replaceAll(" ", "");
        StringBuffer sb = new StringBuffer(s);
        System.out.println(s);
        /**
         * Step1: Reverse the string
         */
        String step1 = sb.reverse().toString();
        System.out.println(step1);

        /**
         * Step2: Rail Fence Cipher Coding
         */
        String step2 = RailFenceCipher.railFenceCipherCoding(step1);
        System.out.println(step2);

        /**
         * Step3: Computer Key Board Coding
         */
        String step3 = "";
        Map<Character, Character> map = KeyBoard.getCodingMap();
        for(int i = 0; i < step2.length(); i++){
            step3 = step3 + map.get(step2.charAt(i));
        }
        System.out.println(step3);

        /**
         * Step4: Covert string to numbers with Nokia phone keyboard
         */
        String step4 = "";
        Map nokiaMap = KeyBoard.getNokiaCodingMap();
        for(int i = 0; i < step3.length(); i++){
            step4 = step4 + nokiaMap.get(step3.charAt(i)) + "";
        }
        System.out.println(step4);

        /**
         * Step5: Convert string to morse code
         */
        String step5 = "";
        Map morseMap = MorseCode.getMorseMap();
        for(int i = 0; i < step4.length(); i++){
            Character c = step4.charAt(i);
            step5 = step5 + morseMap.get(c) + "/";
        }
        System.out.println(step5);
        return step5;
    }

}
