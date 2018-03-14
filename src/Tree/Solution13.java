package Tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution13 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Solution13 solution13 = new Solution13();
        TreeNode treeNode = solution13.createBinaryTreeByArray(array, 0);
        System.out.println(solution13.TreeDepth_2(treeNode));
    }

    /**
     * 非递归，层次遍历
     *
     * @param root
     * @return
     */
    public int TreeDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int start = 0;
        int end = 1;
        int depth = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            start++;
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            if (start == end) {
                start = 0;
                end = queue.size();
                depth++;
            }
        }
        return depth;
    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left) + 1, TreeDepth(root.right) + 1);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            int value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }
}
