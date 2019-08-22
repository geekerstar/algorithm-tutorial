package com.geekerstar.s62;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/31 20:22
 * @Description:
 */
public class Solution {
    private TreeNode ret;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt >= k) {
            return;
        }
        inOrder(root.left, k);
        cnt++;
        if (cnt == k) {
            ret = root;
        }
        inOrder(root.right, k);
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
