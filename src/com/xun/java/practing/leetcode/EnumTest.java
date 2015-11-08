package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cuixun on 5/8/15.
 */
public class EnumTest {
    public static void main(String[]args){
        String[] s = {"asd", null, "qwe"};
        for(String q:s){
            System.out.println(q);
        }
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        Person q = new Person();
        Gender g = Gender.setGender("male");
        Person p = new Person(g);
        System.out.print(p.gender.getName());
        List<String> list = new ArrayList<String>();
        list.add("sad");
        list.add("nive");

        list.clear();
    }


}
