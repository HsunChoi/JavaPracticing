package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 8/8/15.
 */
public class ReverseKthNodes {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode cur = head;
        ListNode cur2 = head2;
        for (int i = 1; i < 10; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
            cur2.next = new ListNode(i);
            cur2 = cur2.next;
        }
        Xun.printListNodes(head);
        System.out.println();

        head = reverseKGroup(head, 4);
        Xun.printListNodes(head);
        System.out.println();

        head2 = reverseKthLinkedList(head2, 4);
        Xun.printListNodes(head2);
    }

    /**
     * Reverse every kth Node
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode kth = kthNode(pre, k);
        head = kth != null ? kth : head;
        ListNode last = pre.next;
        while (last != null && kth != null) {
            last = pre.next;
            ListNode tmp = kth.next;
            reverse(last, kth);
            last.next = tmp;
            pre.next = kth;
            pre = last;
            kth = kthNode(pre, k);
        }
        return head;
    }

    static ListNode kthNode(ListNode pre, int k) {
        ListNode node = pre;
        while (k != 0) {
            node = node.next;
            if (node == null) {
                return null;
            }
            k--;
        }
        return node;
    }

    static void reverse(ListNode left, ListNode right) {
        ListNode n = left.next;
        left.next = null;
        while (n != null && left != right) {
            ListNode tmp = n.next;
            n.next = left;
            left = n;
            n = tmp;
        }

    }

    /**
     * Reverse the first kth Node
     */
    static ListNode reverseKthLinkedList(ListNode head, int k){
        ListNode kthNode = kthNode2(head, k);

        ListNode secStart = kthNode.next;
        kthNode.next = null;
        ListNode tail = head;
        head = reverse(head);
        tail.next = secStart;

        return head;
    }

    public static ListNode kthNode2(ListNode head, int k){
        ListNode node = head;
        while(k != 1){
            node = node.next;
            if (node == null) {
                return null;
            }
            k--;
        }
        return node;
    }

    static ListNode reverse(ListNode head){
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
