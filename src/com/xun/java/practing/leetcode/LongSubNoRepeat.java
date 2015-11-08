package com.xun.java.practing.leetcode;

import java.util.Stack;

/**
 * Created by cuixun on 3/24/15.
 */
public class LongSubNoRepeat {
    public static void main(String[] args) {
        String s = "wehavealotofjuiceandtodrink";
        System.out.println(longSub(s));
        System.out.println(subStrWithoutRepeat(s));
    }

    /**
     * Brute force solution  time complexity is O(n^3)
     *
     * @param s
     * @return
     */
    public static String longSub(String s) {
        int longLength = 0;
        Stack<String> subStrings = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {  // exclutive or not
                String sub = s.substring(i, j + 1);
                if (!isRepeat(sub) && sub.length() > longLength) {
                    subStrings.push(sub);
                    longLength = sub.length();
                }
            }
        }
        return subStrings.peek();
    }

    public static boolean isRepeat(String s) {
        boolean[] buffer = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i);
            if (buffer[x]) {
                return true;
            }
            buffer[x] = true;
        }
        return false;
    }

    /**
     * two pointers' methods, time complexity is O(n)
     *
     * @param s
     * @return
     */
    public static String subStrWithoutRepeat(String s) {
        int i = 0;
        String longSub = "";
        int subLength = 1;
        boolean[] charPool = new boolean[256];
        //initPool(charPool);
        for (int j = 0; j < s.length(); j++) {
            char tmp = s.charAt(j);
            while(charPool[tmp]){
                charPool[s.charAt(i)] = false;
                i++;
            }
            charPool[tmp] = true;
            String t = s.substring(i, j + 1);
            if(t.length() > longSub.length()){
                longSub = t;
                subLength =longSub.length();
            }

        }

        System.out.println(subLength);
        return longSub;
    }
}
