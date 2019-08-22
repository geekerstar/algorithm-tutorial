package com.geekerstar.s22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Geekerstar(QQ : 247507792)
 * @Date: 2018/8/30 18:54
 * @Description:
 */
public class Solution2 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode t = queue.poll();
                if (t == null)
                    continue;
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
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
