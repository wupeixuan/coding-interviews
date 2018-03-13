package Array;

/**
 * 二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[][] arr = new int[][]{{1, 2, 3, 4, 5}, {2, 4, 7, 8, 10}};
        System.out.println(solution11.Find_2(7, arr));
    }

    /**
     * 每一行都按照从左到右递增的顺序排序，把每一行看作有序递增数组
     * 利用二分查找
     * 通过遍历每一行查找得到答案
     * 时间复杂度mlog(n)
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find_3(int target, int[][] array) {
        if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0)) return false;
        for (int i = 0; i < array.length; i++) {
            int begin = 0;
            int end = array[0].length - 1;
            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (target > array[i][mid]) {
                    begin = mid + 1;
                } else if (target < array[i][mid]) {
                    end = mid - 1;
                } else {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * 利用二维数组由上到下，由左到右递增的规律，
     * 那么选取左下角或者右上角的元素a[i][j]与target进行比较，
     * 当target大于元素a[i][j]时，那么target必定在元素a所在行的右边,
     * 即j++；
     * 当target大于元素a[i][j]时，那么target必定在元素a所在列的上边,
     * 即i--；
     * 时间复杂度m+n
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find_2(int target, int[][] array) {
        if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0)) return false;
        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j <= array[0].length) {
            if (target > array[i][j]) {
                j++;
            } else if (target < array[i][j]) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 暴力
     * 时间复杂度mn
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || (array.length == 1 && array[0].length == 0)) return false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
