package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 5/10/15.
 */
public class ListNode {
    Integer val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    void add(int val){
        if(this.next == null || this.next.val == null){
            this.next = new ListNode(val);
        }else{
            this.next.add(val);
        }
    }
}
