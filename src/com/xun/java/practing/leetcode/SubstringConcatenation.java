package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cuixun on 7/20/15.
 * <p>
 * <p>
 * <p>
 * You are given a string, s, and a list of words, words,
 * that are all of the same length. Find all starting indices of substring(s) in s
 * that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p>
 * You should return the indices: [0,9].
 * (order does not matter)
 */
public class SubstringConcatenation {

    public static void main(String[] args) {
//        String[] words = {"word","good","best","good"}; //"foo","bar"
//        String s = "argoodgoodgoodbestword";//"wordgoodgoodgoodbestword", ["word","good","best","good"]
//        List<Integer> list = findSubstring(s, words);
//        List<Integer> list2 = findSubstring2(s, words);
//        Xun.printInteger(list);
//        Xun.printInteger(list2);


        String[] words = {"bar", "foo"};
        String s = "barfoothefoobarman";

        List<Integer> list = findSubstring3(s, words);
        Xun.printInteger(list);


    }

    public static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words.length == 0) {
            return list;
        }
        Map<String, Integer> map = getMap(words); // get a map contains all words and numbers
        int len = words[0].length();
        int totalLen = len * words.length;
        for (int i = 0; i < s.length(); i++) {
            if (i + totalLen > s.length()) {
                break;
            }
            boolean b = isContains(s, i, len, totalLen, new HashMap<String, Integer>(map)); // return true if contains all words
            if (b) {
                list.add(i);
            }
        }
        return list;
    }

    static Map<String, Integer> getMap(String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : words) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        return map;
    }

    static boolean isContains(String s, int start, int len, int totalLen, Map<String, Integer> map) {

        for (int i = start; i + len <= s.length(); i += len) {
            if (i + len <= start + totalLen) {
                String t = s.substring(i, i + len);
                if (!map.containsKey(t)) {
                    return false;
                } else {
                    int x = map.get(t);
                    if (x == 1) {
                        map.remove(t);
                    } else {
                        map.put(t, x - 1);
                    }
                }
            }
        }
        return map.isEmpty();
    }

    /**
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        List<String> dic = new ArrayList<String>();
        int singleLength = words[0].length();
        int length = words.length * singleLength;
        if (s.length() == 0 || words.length == 0 || s.length() < length) {
            return list;
        }
        for (String ss : words) {
            dic.add(ss);
        }
        for (int i = 0; i <= s.length() - length; i++) {
            String x = s.substring(i, i + length);
            if (containsAll(x, singleLength, new ArrayList<>(dic))) {
                list.add(i);
            }
        }
        return list;
    }

    static boolean containsAll(String s, int length, List<String> list) {
        for (int i = 0; i < s.length(); i += length) {
            if (!list.remove(s.substring(i, i + length))) {
                return false;
            }
        }
        return list.isEmpty();
    }

    /**
     * ===========================================================================
     */

    public static List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0) {
            return list;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String ss : words) {
            if (map.containsKey(ss)) {
                map.put(ss, map.get(ss) + 1);
            } else {
                map.put(ss, 1);
            }
        }
        int length = words[0].length() * words.length;
        for (int i = 0; i <= s.length() - length; i++) {
            String ss = s.substring(i, i + length);
            if (containsAll(ss, new HashMap(map), words[0].length())) {
                list.add(i);
            }

        }
        return list;
    }


    static boolean containsAll(String s, Map<String, Integer> map, int len) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += len) {
            String tmp = "";
            for (int j = i; j < i + len; j++) {
                tmp = tmp + arr[j];
            }
            if (!map.containsKey(tmp)) {
                return false;
            }
            if (map.get(tmp) == 1) {
                map.remove(tmp);
            } else {
                map.put(tmp, map.get(tmp) - 1);
            }
        }
        return map.isEmpty();
    }


    public static List<Integer> findSubstringBest(String s, String[] words) {
        int num = words.length;
        int leng = words[0].length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) {
            if (!map.containsKey(w)) {
                map.put(w, 1);
            } else {
                map.put(w, map.get(w) + 1);
            }
        }
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < leng; i++) {
            // count indicates how many "valid" words we have seen consecutively in the current search

            int count = 0;
            HashMap<String, Integer> mapC = new HashMap<>();
            for (int j = i; j + leng <= s.length(); j += leng) {
                String temp = s.substring(j, j + leng);
                if (!map.containsKey(temp)) {

                    count = 0;
                    mapC.clear();
                    //keep going
                } else if (!mapC.containsKey(temp)) {
                    mapC.put(temp, 1);
                    count++;
                    //keep going
                } else if (mapC.get(temp) < map.get(temp)) {
                    mapC.put(temp, mapC.get(temp) + 1);
                    count++;
                    //we need to "invalidate" all words we have seen before the last occurrence of temp
                } else {
                    int k = j - count * leng;
                    while (!s.substring(k, k + leng).equals(temp)) {
                        String t = s.substring(k, k + leng);
                        mapC.put(t, mapC.get(t) - 1);
                        count--;
                        k += leng;
                    }
                }
                if (count == num) {

                    l.add(j - leng * num + leng);
                }
            }

        }
        return l;
    }
}
