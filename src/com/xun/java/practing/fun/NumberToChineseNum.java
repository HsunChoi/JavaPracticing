package com.xun.java.practing.fun;

/**
 * Created by cuixun on 11/26/15.
 */
public class NumberToChineseNum {


    static String[] digit = new String[]{"", "", "十", "百", "千", "万", "十万"};
    static String[] nums = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};



    public static void main(String[]args){
        long x = System.currentTimeMillis();
        for(int i = 1; i <= 10000; i++){
            System.out.format("第" + convertNumToChinese(i) + "遍"
                    + ": " + "世界和平");
            System.out.println();
        }
        long y = System.currentTimeMillis();
        System.out.println(y - x);

    }

    public static String convertNumToChinese(int x){
        String s = Integer.toString(x);
        int len = s.length();
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < len; i++){
            int curDigit = len - i;
            String curNum = nums[Integer.parseInt(Character.toString(s.charAt(i)))];
            String curDig = digit[curDigit];


            if(sb.length() != 0 && sb.charAt(sb.length() - 1) == '零' && curNum == "零"){
                continue;
            }else if(curNum == "零"){
                sb.append(curNum);
            }else{
                sb.append(curNum);
                sb.append(curDig);
            }

        }

        String res = new String(sb);
        if(res.charAt(res.length() - 1) == '零'){
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }



}
