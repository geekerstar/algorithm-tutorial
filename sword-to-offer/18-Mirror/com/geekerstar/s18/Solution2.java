package com.geekerstar.s18;

public class Solution2 {
    public void Mirror(TreeNode root) {
        // 若root不为空，则进行镜像处理，否则不进行任何处理
        if(root != null) {
            // 设置中间变量，将root的左右子树交换（左、右节点是否为空不影响）
            TreeNode tem = null;
            tem = root.left;
            root.left = root.right;
            root.right = tem;
            // 若交换后左子树不为空，则对其镜像处理
            if(root.left != null) {
                Mirror(root.left);
            }
            // 若交换后右子树不为空，则对其镜像处理
            if(root.right != null) {
                Mirror(root.right);
            }
        }
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
