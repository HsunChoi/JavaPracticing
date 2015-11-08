package com.xun.java.practing.leetcode;

import java.util.PriorityQueue;

/**
 * Created by cuixun on 8/7/15.
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedList {
    public static void main(String[]args){

    }
     public static ListNode mergeK(ListNode[] list){
         if(list == null || list.length == 0){
             return null;
         }
         PriorityQueue<ListNode> queue = new PriorityQueue<>();
         for(ListNode node : list){
             if(node != null){
                 queue.offer(node);
             }
         }
         ListNode pre = new ListNode(0);
         ListNode cur = pre;
         while(!queue.isEmpty()){
             ListNode tmp = queue.poll();
             if(tmp.next != null){
                 queue.offer(tmp.next);
             }
             cur.next = tmp;
             tmp.next = null;
             cur = cur.next;
         }
         return pre.next;
     }
}
