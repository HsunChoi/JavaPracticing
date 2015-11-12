package com.xun.java.practing.CodingAndDecoding;

import java.util.Map;

/**
 * Created by cuixun on 11/11/15.
 * Idea and Reference from importnew.
 */
public class Decoding {
    public static String romaDecoding(String s) {
        /**
         * Initialization
         */
        if (s.charAt(0) == '/') {
            s = s.substring(1);
        }
        if (s.charAt(s.length() - 1) != '/') {
            s = s + '/';
        }
        /**
         * Step1: Convert morse code to numbers
         */
        String step1 = "";
        Map morseMap = MorseCode.getMorseDecodingMap();

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (s.charAt(right) != '-' && s.charAt(right) != '*') {
                String subs = s.substring(left, right);
                Character c = (Character) morseMap.get(subs);
                step1 = step1 + c;
                left = right + 1;
            }
            right++;
        }

        System.out.println(step1);

        /**
         * Step2: Convert the numbers to Nokia phone board String
         */
        String step2 = "";
        left = 0;
        right = 2;
        Map nokiaDecodingMap = KeyBoard.getNokiaDecodingMap();
        while(right <= step1.length()){
            String tmp = step1.substring(left, right);
            step2 = step2 + nokiaDecodingMap.get(tmp);
            right += 2;
            left += 2;
        }
        System.out.println(step2);

        /**
         * Step3: Convert Nokia phone board to laptop keyboard
         */
        String step3 = "";
        Map map = KeyBoard.getDecodingMap();
        for(int i = 0; i < step2.length(); i++){
            step3 = step3 + map.get(step2.charAt(i));
        }
        System.out.println(step3);

        /**
         * Step4: Rail Fence Cipher Decode
         */
        String step4 = "";
        step4 = RailFenceCipher.railFenceCipherDecoding(step3);
        System.out.println(step4);

        /**
         * Step5: Reverse the string
         */
        String step5 = "";
        StringBuffer sb = new StringBuffer(step4);
        sb.reverse();
        step5 = sb.toString().toUpperCase();
        System.out.println(step5);
        return step5;

    }
}
