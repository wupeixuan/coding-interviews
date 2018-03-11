package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 思路：
 * 先按层次输出二叉树
 * 判断奇数层和偶数层
 * 反转arrayList
 */
public class Solution9 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Solution9 Solution9 = new Solution9();
        TreeNode treeNode = Solution9.createBinaryTreeByArray(array, 0);
        for (ArrayList list :
                Solution9.Print(treeNode)) {
            System.out.println(list);
        }
    }

    /**
     * 之字形打印二叉树
     * 用reserve反转，时间复杂度高
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        //arrayLists存储结果
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null) {
            return arrayLists;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        //使用队列，先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int start = 0;
        int end = 1;
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            //添加到本行的arrayList
            arrayList.add(temp.val);
            start++;
            //每打印一个节点，就把此节点的下一层的左右节点加入队列，并记录下一层要打印的个数
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

            if (start == end) {
                start = 0;
                end = queue.size();
                if (leftToRight) {
                    arrayLists.add(arrayList);
                } else {
                    arrayLists.add(reverse(arrayList));

                }
                leftToRight = !leftToRight;
                arrayList = new ArrayList<>();
            }
        }
        return arrayLists;
    }

    /**
     * 反转
     *
     * @param arrayList
     * @return
     */
    private ArrayList<Integer> reverse(ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            arrayList1.add(arrayList.remove(i));
        }
        return arrayList1;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 数据转二叉树
     *
     * @param array
     * @param index
     * @return
     */
    private TreeNode createBinaryTreeByArray(int[] array, int index) {
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
