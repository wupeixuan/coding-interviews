package Tree;

import java.util.Stack;

/**
 * 二叉搜索树的第k个结点
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * 思路：
 * 利用二叉搜索数中序遍历有序的特点。
 */
public class Solution49 {
    private int cnt;
    private TreeNode res;

    /**
     * 迭代中序遍历
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode_2(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0)
            return null;
        int cnt = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (pRoot != null || !stack.isEmpty()) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            pRoot = stack.pop();
            cnt++;
            if (cnt == k) return pRoot;
            pRoot = pRoot.right;
        }
        return null;
    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return res;
    }

    /**
     * 递归中序遍历
     *
     * @param pRoot
     * @param k
     */
    void inOrder(TreeNode pRoot, int k) {
        if (pRoot == null) return;
        if (cnt > k) return;
        inOrder(pRoot.left, k);
        cnt++;
        if (cnt == k) res = pRoot;
        inOrder(pRoot.right, k);
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
