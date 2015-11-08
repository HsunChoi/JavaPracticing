package com.xun.java.practing.leetcode;

import apple.laf.JRSUIUtils;

/**
 * Created by cuixun on 7/16/15.
 */
public class LowestCommonAncestorOfBinaryTree {
    public static void main(String[]args){

    }

    /**
     * Normal binary tree
     * @param root
     * @param p
     * @param q
     * @return
     */
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        boolean pLeft = isHere(root.left, p);
        boolean qLeft = isHere(root.left, q);
        if(pLeft && qLeft){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(!pLeft && !qLeft){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }



    static boolean isHere(TreeNode root, TreeNode target){
        if(root == null){
            return false;
        }
        if(root == target){
            return true;
        }
        return isHere(root.left, target) || isHere(root.right, target);
    }


    static TreeNode lowAncestorBinarySearchTree(TreeNode root, TreeNode p, TreeNode q){
        int small = p.value < q.value ? p.value : q.value;
        int large = p.value > q.value ? p.value : q.value;
        if(small <= root.value && large >= root.value){
            return root;
        }
        if(large < root.value){
            return lowAncestorBinarySearchTree(root.left, p, q);
        }
        return lowAncestorBinarySearchTree(root.right, p, q);
    }

}
