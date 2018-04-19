package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution54 {
    private Map<Integer, Integer> inOrderNumsIdx = new HashMap<>(); // 缓存中序遍历数组的每个值对应的索引

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            inOrderNumsIdx.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        if (preL == preR) return new TreeNode(pre[preL]);
        if (preL > preR || inL > inR) return null;
        // 创建当前根节点，并为根节点赋值
        TreeNode root = new TreeNode(pre[preL]);
        int inIdx = inOrderNumsIdx.get(root.val);
        int leftTreeSize = inIdx - inL;
        // 构建左子树
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, in, inL, inL + leftTreeSize - 1);
        // 构建右子树
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, in, inL + leftTreeSize + 1, inR);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
