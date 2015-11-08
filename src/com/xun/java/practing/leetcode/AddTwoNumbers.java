package com.xun.java.practing.leetcode;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by cuixun on 3/24/15.
 * LeetCode
 * given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their
 * nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Random r = new Random();
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list1.add(r.nextInt(10));
            list2.add(r.nextInt(10));
        }
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");
        }
        System.out.println();
        LinkedList<Integer> list = addTwoNumber(list1, list2);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    public static LinkedList<Integer> addTwoNumber(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        LinkedList<Integer> sum = new LinkedList<Integer>();
        int carry = 0;

        while (list1.size() != 0 && list2.size() != 0) {
            int digitSum = list1.pollFirst() + list2.pollFirst() + carry;
            carry = digitSum / 10;
            digitSum = digitSum % 10;
            sum.add(digitSum);
        }
        while (list1.size() != 0) {
            int digitSum = list1.pollFirst() + carry;
            carry = digitSum / 10;
            digitSum = digitSum % 10;
            sum.add(digitSum);
        }
        while (list2.size() != 0) {
            int digitSum = list2.pollFirst() + carry;
            carry = digitSum / 10;
            digitSum = digitSum % 10;
            sum.add(digitSum);
        }
        if(carry != 0){
            sum.add(carry);
        }

        return sum;
    }


}
