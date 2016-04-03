package com.xun.java.practing.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 2/29/16.
 */
public class SkyLine {

    public static void main(String[] args) {
        int[][] buildings = {
                {
                        1, 3, 3
                },
                {
                        2, 4, 4
                },
                {
                        5, 6, 1
                }
        };

        getSkyline(buildings);
    }


    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> list = new LinkedList<int[]>();
        if (buildings == null || buildings.length == 0) {
            return list;
        }
        int length = 0;
        for (int i = 0; i < buildings.length; i++) {
            length = Math.max(buildings[i][1], length);
        }
        if (length == Integer.MAX_VALUE) {
            length = length - 1;
        }
        int[] skyLine = new int[length + 1];
        for (int i = 0; i < buildings.length; i++) {
            int[] curBuilding = buildings[i];
            mergeSkyLine(skyLine, curBuilding);
        }
        convertSkyLine(list, skyLine);
        return list;

    }


    static void mergeSkyLine(int[] skyLine, int[] building) {
        int start = building[0];
        int end = building[1];
        int height = building[2];
        for (int i = start; i < end; i++) {
            skyLine[i] = Math.max(height, skyLine[i]);
        }
    }


    static void convertSkyLine(List<int[]> list, int[] skyLine) {

        for (int i = 0; i < skyLine.length; ) {
            if(skyLine[i] == 0){
                i++;
                continue;
            }
            int height = skyLine[i];
            int j = i;
            while (height > 0 && j < skyLine.length && height == skyLine[j]) {
                j++;
            }
            //j -= 1;
            if (j != i) {
                int[] curLine = new int[3];
                curLine[0] = i;

                curLine[1] = j;

                curLine[2] = height;
                list.add(curLine);
                i = j;
            } else {
                i++;
            }

        }

    }
}
