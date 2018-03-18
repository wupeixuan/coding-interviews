package Array;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution27 {

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(solution27.minNumberInRotateArray_2(array));

    }

    /**
     * 二分法，但是要考虑完全旋转和无法判断最小值在那个部位的情况
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray_2(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        //旋转过
        while (array[left] >= array[right]) {
            //当left和right两个指针相邻时候，就找到了最小值
            if (right - left <= 1) {
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            //无法确定中间元素是属于前面还是后面的子数组
            if (array[left] == array[mid] && array[right] == array[mid]) {
                return minNumber(array, left, right);
            }
            //array[mid]在左边序列
            if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {//array[mid]在右边序列
                right = mid;
            }
        }
        return array[mid];
    }

    private int minNumber(int[] array, int left, int right) {
        int result = array[left];
        for (int i = left + 1; i < right; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;
    }


    /**
     * 暴力
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result >= array[i]) {
                result = array[i];
            }
        }
        return result;
    }
}
