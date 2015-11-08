package com.xun.java.practing.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cuixun on 6/29/15.
 */
public class MergeIntervals {

    public static void main(String [] args){

    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start == o2.start) {
                    return 0;
                }else if(o1.start < o2.start){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        for(int i = 0; i < intervals.size() - 1; i++){
            Interval ini = intervals.get(i);
            Interval ini2 = intervals.get(i + 1);
            if(ini.end > ini2.end){
                intervals.remove(i + 1);
                i--;
            }else if(ini2.start > ini.end){

            }else{
                Interval interval = new Interval(ini.start, ini2.end);
                intervals.remove(i + 1);
                intervals.remove(i);
                intervals.add(i, interval);
                i--;
            }
        }
        return intervals;
    }
}
