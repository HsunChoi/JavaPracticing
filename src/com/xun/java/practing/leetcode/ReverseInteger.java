package com.xun.java.practing.leetcode;

import java.util.*;

/**
 * Created by cuixun on 3/28/15.
 */
public class ReverseInteger {
    public static void main(String[]args){
        int x = 1534236469;
        //int y = reverseInt(x);
        int z = reverse(x);
        //System.out.println(y);
        System.out.println(z);

    }

    /**
     * Input here must be an integer
     * @param x
     * @return
     */
    public static int reverseInt(int x){
        int sign = 1;
        if(x < 0){
            sign = -1;
            x = -x;
        }
        List<Integer> stack = new ArrayList<Integer>();
        while(x / 10 != 0){
            int mod = x % 10;
            stack.add(mod);
            x = x / 10;
        }
        stack.add(x);
        String s = "";
        while(!stack.isEmpty()){
            s = s + stack.remove(0);
        }
        return sign * Integer.parseInt(s);
    }

    public static int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        StringBuffer sb = new StringBuffer(Integer.toString(x));
        sb.reverse();
        String s = new String(sb);
        try {
            return sign * Integer.parseInt(s);
        }catch (Exception e){
            return Integer.MAX_VALUE;
        }

    }
}
