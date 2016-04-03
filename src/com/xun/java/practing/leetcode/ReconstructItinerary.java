package com.xun.java.practing.leetcode;

import java.util.*;

/**
 * Created by cuixun on 2/20/16.
 */
public class ReconstructItinerary {

    public static void main(String[] args) {
        String[][] strings = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};

        //Xun.printString(findItinerary(strings));

    }


    public static List<String> findItinerary(String[][] tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        List<String> list = new ArrayList<String>();
        if (tickets == null || tickets.length == 0) {
            return list;
        }

        for (int i = 0; i < tickets.length; i++) {
            String departure = tickets[i][0];
            String arrival = tickets[i][1];
            if (map.containsKey(departure)) {
                Queue q = map.get(departure);
                q.offer(arrival);
                map.put(departure, q);
            } else {
                PriorityQueue<String> queue = new PriorityQueue<>();
                queue.offer(arrival);
                map.put(departure, queue);
            }
        }
        String cur = "JFK";
        list.add(cur);
        while (map.containsKey(cur)) {
            Queue<String> q = map.get(cur);
            String arrival = q.poll();
            if (q.isEmpty()) {
                map.remove(cur);
            }
            //list.add(cur);
            list.add(arrival);
            cur = arrival;
        }
        return list;
    }
}
