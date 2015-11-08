package com.xun.java.practing.leetcode;

import java.util.ArrayList;

/**
 * Created by cuixun on 4/8/15.
 */
public class CheckBST {
    public static void main(String[]args){

    }

    public static boolean checkBST(BinaryTree tree){
        return checkBST(tree.root, null, null);
    }

    /**
     * min and max methods because all the data on the left are less than the current data. and
     * all the data on the right are larger than the current data, so we recursively use this method
     * to check whether it is a binary search tree
     * @param root
     * @param min
     * @param max
     * @return
     */
    public static boolean checkBST(Node root, Integer min, Integer max){
        if(root == null){
            return true;
        }

        if((min != null && root.data < min) ||(max != null && root.data > max)){
            return false;
        }

        return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
    }

    /**
     * Check methods with traversal idea. we list the node in a list in in-Order traversal.
     * check whether the previous data is less than the post data
     * @param root
     * @return
     */
    public static boolean checkBST(Node root){
        ArrayList<Node> list = new ArrayList<Node>();
        checkBST(root, list);
        for(int i = 1; i < list.size(); i++){
            if(list.get(i- 1).data > list.get(i).data){
                return false;
            }
        }
        return true;
    }
    public static void checkBST(Node root, ArrayList<Node> list){
        if(root == null){
            return;
        }
        checkBST(root.left, list);
        list.add(root);
        checkBST(root.right, list);
    }
}
