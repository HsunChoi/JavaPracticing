package com.xun.java.practing.careerup.StackSort.src;

import java.util.Stack;

/**
 * Created by cuixun on 4/3/15.
 */
public class StackSort {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 9; i >= 0; i--) {
            stack.push(array[i]);
            System.out.print(stack.peek() + " ");
        }
        sortStack(stack);
        System.out.println();
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    /**
     * Sort stack with another stack
     * @param stack
     */

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> buffer = new Stack<Integer>();
        while (!stack.isEmpty()) {
            buffer.push(stack.pop());
        }
        stack.push(buffer.pop());
        int x;
        while (!buffer.isEmpty()) {
            x = buffer.pop();
            while (!stack.isEmpty() && x < stack.peek()) {
                buffer.push(stack.pop());
            }
            stack.push(x);
        }

    }
}
