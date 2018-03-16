package Tree;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树（Balanced Binary Tree）又被称为AVL树（有别于AVL算法），且具有以下性质：
 * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 */
public class Solution20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        int[] array = {8, 6, 10, 5, 7, 9, 11};
        TreeNode treeNode = solution20.createBinaryTreeByArray(array, 0);
        System.out.println(solution20.IsBalanced_Solution_2(treeNode));
    }

    /**
     * 从下往上遍历，如果子树是平衡二叉树，则返回子树高度，否则返回-1
     * 时间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution_2(TreeNode root) {
        return MaxDepth_2(root) != -1;
    }

    public int MaxDepth_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = MaxDepth_2(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = MaxDepth_2(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * 遍历每个结点，借助一个获取树深度的递归函数，根据该结点的左右子树高度差判断是否平衡，然后递归地对左右子树进行判断。
     * 时间复杂度：O(n^2)
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(MaxDepth(root.left) - MaxDepth(root.right)) > 1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int MaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(MaxDepth(root.left), MaxDepth(root.right));
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
