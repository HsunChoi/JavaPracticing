package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 8/11/15.
 * Sort a linked list using insertion sort.
 */
public class InsertSortedList {
    public static void main(String[]args){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i = 9; i > 0; i--){
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        head = insertionSortList(head);
        Xun.printListNodes(head);
    }


    public static ListNode insertionSortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(0);
        while(head != null){
            insert(pre, head.val);
            head = head.next;
        }
        return pre.next;
    }

    static void insert(ListNode pre, int x){
        ListNode tmp = new ListNode(x);
        if(pre.next == null){
            pre.next = tmp;
            return;
        }
        while(pre.next != null){
            if(pre.next.val >= x){
                tmp.next = pre.next;
                pre.next = tmp;
                return;
            }
            pre = pre.next;
        }
        pre.next = tmp;
    }
}
