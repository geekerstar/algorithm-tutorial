package com.geekerstar.s38;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 18:18
 * @Description:
 */
public class Solution {
    public int TreeDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
