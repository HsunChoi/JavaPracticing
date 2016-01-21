package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 1/19/16.
 */
public class OddEvenList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 9; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        Xun.printListNodes(head);
        Xun.printListNodes(oddEvenList(head));

    }


    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode cur = even;
        while (cur != null && cur.next != null) {

            odd.next = cur.next;
            even.next = cur.next.next;
            odd = odd.next;
            even = even.next;
            cur = even;

        }

        odd.next = evenHead;
        if (even != null) {
            even.next = null;
        }

        return head;
    }
}
