package com.geekerstar.problem;

public class BST {
    // BST中的节点
    TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 插入操作
    public void insertIntoBST(int val) {
        root = insertIntoBST(root, val);
    }

    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (val < root.val)
            root.left = insertIntoBST(root.left, val);
        else if (val > root.val)
            root.right = insertIntoBST(root.right, val);
        return root;
    }

    /*
     * 待删除节点可能有四种情况：
     * 1.待删除节点：没有左孩子也没有右孩子，删除节点后return null即可
     * 2.待删除节点：只有左孩子，删除节点后return 该节点的左子树即可
     * 3.待删除节点：只有右孩子，删除节点后return 该节点的右子树即可
     * 4.待删除节点：左孩子和右孩子都不为null：用待删除节点的右子树中最小的节点值，
     *   也就是用待删除节点的右子树最左端的节点值替换待删除节点的值，然后删除待删除节点的右子树最左端的节点即可
     *   （该节点没有左孩子），因为是最左端节点。
     */

    public void deleteNode(int val) {
        root = deleteNode(root, val);
    }

    private TreeNode deleteNode(TreeNode curNode, int key) {
        if (curNode == null) {
            return null;
        }
        if (key < curNode.val) {
            curNode.left = deleteNode(curNode.left, key);
        } else if (key > curNode.val) {
            curNode.right = deleteNode(curNode.right, key);
        } else {
            // curNode为带输出节点
            if (curNode.left == null) {// 待删除节点只有右孩子或者没有孩子节点
                return curNode.right;
            } else if (curNode.right == null) {// 待删除节点只有左孩子
                return curNode.left;
            }

            // 左右孩子都有

            // 找到待删除节点右子树中最left的节点，也就是右子树中值最小的节点
            TreeNode minNode = findMin(curNode.right);

            curNode.val = minNode.val;// 更新curNode的值为待删除节点右子树中值最小的节点的值

            // 删除curNode右子树中值最left的节点
            curNode.right = deleteNode(curNode.right, curNode.val);
        }
        return curNode;
    }

    // 找到以node为根节点的所有节点中值最小的节点，也就是最左端的节点
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // 迭代的方式刪除
    private TreeNode deleteNode1(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            pre = cur;
            if (key < cur.val) {
                cur = cur.left;
            } else if (key > cur.val) {
                cur = cur.right;
            } else
                break;
        }

        // cur指向待删除节点
        if (cur == null)
            return null;// 没找到待删除节点
        if (pre == null) {// 删除根节点
            root = deleteRootNode(cur);
        } else if (pre.left == cur) {// 删除左节点
            pre.left = deleteRootNode(cur);
        } else {// 删除有节点
            pre.right = deleteRootNode(cur);
        }
        return root;
    }

    private TreeNode deleteRootNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode next = root.right;
        TreeNode pre = root;
        // next指向待删除节点的右分支最小节点
        // pre指向next的父节点
        for (; next.left != null; pre = next, next = next.left)
            ;

        next.left = root.left;
        if (root.right != next) {// 不是要删除next节点本身
            pre.left = next.right;
            next.right = root.right;
        }
        return next;
    }

    //查找操作
    public int searchBST(int val) {
        TreeNode search = searchBST(root, val);

        return search == null ? -1 : search.val;
    }

    // 递归查找
    private TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;

        if (val > root.val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }

    // 迭代查找
    private TreeNode searchBST1(TreeNode root, int val) {

        if (root == null) {
            return null;
        }
        while (true) {
            if (root.val == val) {
                return root;
            } else if (root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }

            if (root == null) {
                return null;
            }
        }
    }
}
