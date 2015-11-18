package com.xun.java.practing.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuixun on 11/17/15.
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * For example, given the following binary tree:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p>
 * ["1->2->5", "1->3"]
 */
public class BinaryTreePath {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        addPath(root, new String(""), list);


        return list;
    }

    static void addPath(TreeNode root, String s, List list) {
        if (s.length() == 0) {
            s = root.value + "";
        } else {
            s = s + "->" + root.value + "";
        }
        if (root.left == null && root.right == null) {
            list.add(s);
            return;
        }
        if(root.left != null){
            addPath(root.left, s, list);
        }
        if (root.right != null){
            addPath(root.right, s, list);
        }

    }


}
