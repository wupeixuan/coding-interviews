package Tree;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution53 {
    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int[] sequence = {5,7,6,9,11,10,8};
        System.out.println(solution53.VerifySquenceOfBST(sequence));
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) return true;
        int rootVal = sequence[last];
        int cutIndex = first;//cutIndex记录比rootVal（根节点）大的第一个元素的索引
        while (cutIndex < last && sequence[cutIndex] <= rootVal) cutIndex++;
        //如果右子树有元素小于root，返回false
        for (int i = cutIndex + 1; i < last; i++) {
            if (sequence[i] < rootVal) return false;
        }
        //递归求解左子树和右子树
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
    }
}
