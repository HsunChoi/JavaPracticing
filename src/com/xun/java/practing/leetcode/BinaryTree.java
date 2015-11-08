package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 3/23/15.
 */
public class BinaryTree {
    Node root;

    public BinaryTree() {

    }

    public BinaryTree(Node root) {
        this.root = root;
    }


    /**
     * pre-Order traversal
     *
     * @param root
     */
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");//Operations can be changed here
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * in-Order traversal
     *
     * @param root
     */
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");//Operations can be changed here
            inOrder((root.right));
        }
    }

    /**
     * post-Order traversal
     *
     * @param root
     */
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");//Operations can be changed here
        }
    }

    public void insert(Node root, int data) {
        if (data <= root.data) {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                insert(root.right, data);
            }
        }
    }

    public void add(int[] values) {
        for (int i = 0; i < values.length; i++) {
            this.insert(this.root, values[i]);
        }
    }

}
