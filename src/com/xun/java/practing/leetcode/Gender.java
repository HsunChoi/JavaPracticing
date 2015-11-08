package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 5/21/15.
 */
public enum Gender {

    MALE("male"),
    FEMALE("female");
    private String name;

    private Gender(String name) {
        this.name = name;
    }

    public static Gender setGender(String s) {
        if (s == "male" || s == "female") {
            if (s == "male") {
                return Gender.MALE;
            } else {
                return Gender.FEMALE;
            }
        }
        return null;

    }

    public String getName() {
        return this.name;
    }

}
