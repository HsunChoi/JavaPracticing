package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 3/27/15.
 */
public class zigZagString {
    public static void main(String[]args){
        String s = "PAYPALISHIRING";
        System.out.println(zigzag(s, 3));

    }

    public static String zigzag(String str, int nRows){
        StringBuffer[] stringBuffer = new StringBuffer[nRows];
        for(int i = 0; i < nRows; i++){
            stringBuffer[i] = new StringBuffer();
        }
        int index = 0;
        int pointer = 0;

        while(pointer < str.length()){
            if(index == nRows){
                index = 0;
            }
            if(index % (nRows - 1) != 0){
                stringBuffer[index].append(str.charAt(pointer));
                index++;
                pointer++;
            }else if(stringBuffer[index].length() % (nRows - 1) == 0){
                stringBuffer[index].append(str.charAt(pointer));
                index++;
                pointer++;
            }else{
                stringBuffer[index].append(" ");
                index++;
            }
        }
        String s = new String(stringBuffer[0]);
        //System.out.println(s);
        if(nRows  > 1){
            for(int i = 1; i < stringBuffer.length; i++){
                String s1 = new String(stringBuffer[i]);
                //System.out.println(s1);
                s = s + s1;
            }
        }
        s = deleteSpace(s);
        return s;
    }

    public static String deleteSpace(String s){
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))){
                buffer.append(s.charAt(i));
            }
        }
        return new String(buffer);
    }
}
