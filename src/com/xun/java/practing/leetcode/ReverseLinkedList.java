package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 12/17/15.
 */
public class ReverseLinkedList {
    public static void main(String[]args){
        ListNode head = new ListNode(0);
        ListNode l1 = head;
        //ListNode l2 = head;
        ListNode ref = head;

        for(int i = 1; i < 10; i++){
            head.next = new ListNode(i);
            head= head.next;
        }
        while(ref != null){
            System.out.print(ref.val + " ");
            ref = ref.next;
        }
        System.out.println();
        head = reverseLinkedList(l1);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }

    }

    public static ListNode reverseLinkedList(ListNode head){
        ListNode cur = null;
        while(head.next != null){
            ListNode tmp = head.next;
            head.next = cur;
            cur = head;
            head = tmp;
        }
        head.next = cur;
        return head;
    }
}
