package com.xun.java.practing.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cuixun on 4/27/15.
 */
public class PermutationQuestions {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] b = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(isPermutation(a, b));

    }

    /**
     * Check whether two integer arrays are permutations
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isPermutation(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        /**
         * put all the number of elements in a map
         */
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        /**
         * check whether b have the same elements with a, and minus 1
         * if all the values in the map is 0 return true, else return false
         */
        for (int i = 0; i < b.length; i++) {
            if (!map.containsKey(b[i])) {
                return false;
            } else {
                int tmp = map.get(b[i]) - 1;
                if (tmp < 0) {
                    return false;
                } else {
                    map.put(b[i], tmp);
                }
            }

        }

        for (int i = 0; i < a.length; i++) {
            int tmp = map.get(a[i]);
            if (tmp != 0) {
                return false;
            }
        }

        return true;
    }


}
