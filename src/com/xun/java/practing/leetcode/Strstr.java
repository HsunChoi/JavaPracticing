package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 3/27/15.
 */
public class Strstr {
    public static void main(String[]args){
        String str = "zacjndjakndijkncoq djnoiq asdnoeikms";
        String target = "jndj";
        System.out.println(strstr(str, target));

    }
    public static int strstr(String str, String target){
        for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){
                if(j == target.length()){
                    return i;
                }
                if(str.charAt(i + j) != target.charAt(j)){
                    break;
                }

            }
        }
        return -1;
    }
}
