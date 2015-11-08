package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cuixun on 7/20/15.
 *
 *
 *
 * You are given a string, s, and a list of words, words,
 * that are all of the same length. Find all starting indices of substring(s) in s
 * that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter)
 */
public class SubstringConcatenation {

    public static void main(String[]args){
        String[] words = {"word","good","best","good"}; //"foo","bar"
        String s = "argoodgoodgoodbestword";//"wordgoodgoodgoodbestword", ["word","good","best","good"]
        List<Integer> list = findSubstring(s, words);
        List<Integer> list2 = findSubstring2(s, words);
        Xun.printInteger(list);
        Xun.printInteger(list2);
    }
    public static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || words.length == 0){
            return list;
        }
        Map<String, Integer> map = getMap(words); // get a map contains all words and numbers
        int len = words[0].length();
        int totalLen = len * words.length;
        for(int i = 0; i < s.length(); i++){
            if(i + totalLen > s.length()){
                break;
            }
            boolean b = isContains(s, i, len, totalLen, new HashMap<String, Integer>(map)); // return true if contains all words
            if(b){
                list.add(i);
            }
        }
        return list;
    }

    static Map<String, Integer> getMap(String[] words){
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String s : words){
            if(!map.containsKey(s)){
                map.put(s, 1);
            }else{
                map.put(s, map.get(s) + 1);
            }
        }
        return map;
    }
    static boolean isContains(String s, int start, int len, int totalLen, Map<String, Integer> map){

        for(int i = start; i + len <= s.length(); i += len){
            if(i + len <= start + totalLen) {
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
     *
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        List<String> dic = new ArrayList<String>();
        int singleLength = words[0].length();
        int length = words.length * singleLength;
        if(s.length() == 0 || words.length == 0 || s.length() < length){
            return list;
        }
        for(String ss : words){
            dic.add(ss);
        }
        for(int i = 0; i <= s.length() - length; i++){
            String x = s.substring(i, i + length);
            if(containsAll(x, singleLength, new ArrayList<>(dic))){
                list.add(i);
            }
        }
        return list;
    }

    static boolean containsAll(String s, int length, List<String> list){
        for(int i = 0; i < s.length(); i += length){
            if(!list.remove(s.substring(i, i + length))){
                return false;
            }
        }
        return list.isEmpty();
    }
}
