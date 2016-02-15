package com.xun.java.practing.careerup.LongestMonotonicSubsequenceIn2D;

import java.util.Comparator;

/**
 * Created by cuixun on 2/14/16.
 */
public class Comparators {

    public static Comparator getSmallToLargeSATComparator(){
        return new SmallToLargeSATComparator();
    }

    public static Comparator getLargeToSmallGPAComparator(){
        return new LargeToSmallGPAComparator();
    }


}

class SmallToLargeSATComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        return s1.getSat() - s2.getSat();
    }
}

class LargeToSmallGPAComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        int x = s1.getGpa() > s2.getGpa() ? -1 : 1;
        return x;
    }
}

