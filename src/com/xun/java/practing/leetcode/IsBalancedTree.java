package com.xun.java.practing.leetcode;

import scala.Left;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 4/3/16.
 */
public class IsBalancedTree {


    public static void main(String[]args){
        List<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(0);
        list.add(root);

        int deep = 5;
        buildBalanceTree(list, 1, deep);
        System.out.println(isBalanceTree(root));
        Xun.printTree(root);
    }




    public static boolean isBalanceTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = getBalanceHeight(root.left);
        int right = getBalanceHeight(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return false;
        }

        return true;

    }


    static int getBalanceHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = getBalanceHeight(root.left);
        int right = getBalanceHeight(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left, right) + 1;


    }

    static void buildBalanceTree(List<TreeNode> list, int cur, int deep){

        if(cur >= deep){
            return;
        }

        List<TreeNode> nexList = new LinkedList<>();

        for(TreeNode node : list){
            node.left = new TreeNode(0);
            node.right = new TreeNode(0);
            nexList.add(node.left);
            nexList.add(node.right);
        }
        buildBalanceTree(nexList, cur + 1, deep);

    }



}
