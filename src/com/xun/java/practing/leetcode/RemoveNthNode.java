package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 5/10/15.
 */
public class RemoveNthNode {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = new ListNode(a[0]);
        for(int i = 1; i < a.length; i++){
            head.add(a[i]);
        }
        ListNode head2 = head;
        print(head);
        removeNthFromEnd(head, 4);
        print(head);
        remove2thMethod(head2, 4);
        print(head2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        int count = 1;
        ListNode pre = new ListNode(head.val);
        ListNode post = new ListNode(head.val);
        pre = post = head;
        while (pre.next != null) {
            pre = pre.next;
            count++;
        }
        if (count == n) {
            head = head.next;
            return head;
        }
        while (count > n + 1) {
            post = post.next;
            count--;
        }
        if (post.next.next != null) {
            post.next = post.next.next;
        } else {
            post.next = null;
        }
        return head;
    }

    static ListNode remove2thMethod(ListNode head, int n){
        ListNode pre = new ListNode(head.val);
        ListNode post = new ListNode(head.val);
        pre = post = head;
        while(n > 0){
            pre = pre.next;
            if(pre == null){
                head = head.next;     //n >= the length which means we need to remove the first ListNode;
                return head;
            }
            n--;
        }
        while(pre.next != null){
            pre = pre.next;
            post = post.next;
        }
        if(post.next.next == null){
            post.next = null;
        }else{
            post.next = post.next.next;
        }


        return head;
    }

    static void print(ListNode head) {
        while(head != null && head.val != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
