package com.xun.java.practing.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cuixun on 6/26/15.
 */
public class TreeTraversalii {
    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        Xun.printList(levelOrderBottom(root));
    }


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        List<TreeNode> nodes = new LinkedList<TreeNode>();
        if(root == null){
            return lists;
        }
        nodes.add(root);
        traversal(lists, nodes);

        return lists;
    }

    static void traversal(List<List<Integer>> lists, List<TreeNode> cur){
        List<Integer> list = new LinkedList<Integer>();
        List<TreeNode> nne = new LinkedList<TreeNode>();
        if(cur.size() != 0){
            for(TreeNode n : cur){
                if(n != null){
                    if(n.left != null){
                        nne.add(n.left);
                    }
                    if(n.right != null){
                        nne.add(n.right);
                    }
                    list.add(n.value);
                }
            }
        }
        if(nne != null && nne.size() != 0) {
            traversal(lists, nne);
        }
        if(list.size() != 0){
            lists.add(list);
        }
    }
}
