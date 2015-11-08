package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 3/23/15.
 */
public class BinaryTreeTraversal {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = {5, 9, 3, 5, 4, 6, 1, 3, 2, 10,};
        tree.root = new Node(values[0]);
        for (int i = 1; i < values.length; i++) {
            tree.insert(tree.root, values[i]);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}
