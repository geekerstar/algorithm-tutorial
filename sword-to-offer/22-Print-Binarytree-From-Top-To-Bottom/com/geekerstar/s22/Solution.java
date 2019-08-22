package com.geekerstar.s22;

import java.util.ArrayList;

/**
 思路是用arraylist模拟一个队列来存储相应的TreeNode
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
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