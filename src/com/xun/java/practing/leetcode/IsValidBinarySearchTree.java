package com.xun.java.practing.leetcode;

/**
 * Created by cuixun on 11/18/15.
 */
public class IsValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return isValidBST(root.left, null, root.value) &&
                isValidBST(root.right, root.value, null);
    }

    public boolean isValidBST(TreeNode root, Integer small, Integer large){
        if(root == null){
            return true;
        }
        if(small != null && large != null){
            if(small >= root.value || root.value >= large){
                return false;
            }
        }else if(small != null && large == null){
            if(small >= root.value){
                return false;
            }
        }else if(small == null && large != null){
            if(root.value >= large){
                return false;
            }
        }
        return isValidBST(root.left, small, root.value) &&
                isValidBST(root.right, root.value, large);
    }
}
