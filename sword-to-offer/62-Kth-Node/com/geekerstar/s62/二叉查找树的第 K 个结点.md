## 题目描述

给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。

题目地址：https://www.nowcoder.com/questionTerminal/ef068f602dde4d28aab2b210e859150a

## 解题思路

利用二叉查找树中序遍历有序的特点。

完整解析：https://www.jikewenku.com/problem/5232.html

```java
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

```

