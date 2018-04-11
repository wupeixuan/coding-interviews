package Array;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution48 {
    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int[] array = {1, 2, 3, 4, 5, 6};
        solution48.reOrderArray_2(array);
        for (int i :
                array) {
            System.out.print(i + " ");
        }
    }

    /**
     * 由于要保证稳定即证奇数和奇数,偶数和偶数之间的相对位置不变,使用插入排序思想
     * 复杂度：O(N2) + O(1)
     *
     * @param array
     */
    public void reOrderArray_2(int[] array) {
        if (array.length == 0 || array == null)
            return;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 0) {
                int nextOddIdx = i + 1;
                while (nextOddIdx < n && array[nextOddIdx] % 2 == 0) {
                    nextOddIdx++;
                }
                if (nextOddIdx == n) {
                    break;
                }
                int nextOddVal = array[nextOddIdx];
                for (int j = nextOddIdx; j > i; j--) {
                    array[j] = array[j - 1];
                }
                array[i] = nextOddVal;
            }
        }
    }

    /**
     * 新建一个数组
     * 复杂度：O(N) + O(N)
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        int oddCnt = 0;
        for (int val : array) {
            if (val % 2 == 1) {
                oddCnt++;
            }
        }
        int[] copy = array.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1) {
                array[i++] = num;
            } else {
                array[j++] = num;
            }
        }
    }
}
