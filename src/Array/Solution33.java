package Array;

/**
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution33 {
    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] array = {1, 3, 4, 5, 5, 6, 7, 8, 9, 10};
        System.out.println(solution33.GetNumberOfK_3(array, 5));
    }

    /**
     * 二分查找 找到第一个k和最后一个k二者位置相减
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK_3(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int number = 0;
        int first = GetFirstIndex(array, k, 0, array.length - 1);
        int last = GetLastIndex(array, k, 0, array.length - 1);
        if (first > -1 && last > -1)
            number = last - first + 1;
        return number;
    }

    /**
     * 找到最后一个k的位置
     *
     * @param array
     * @param k
     * @param left
     * @param right
     * @return
     */
    private int GetLastIndex(int[] array, int k, int left, int right) {
        if (left > right)
            return -1;
        int mid = left + ((right - left) >> 1);
        if (array[mid] == k) {
            if (mid == right || (array[mid + 1] != k)) {
                return mid;
            } else {
                left = mid + 1;
            }
        } else if (array[mid] > k) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return GetLastIndex(array, k, left, right);
    }

    /**
     * 找到第一个k的位置
     *
     * @param array
     * @param k
     * @param left
     * @param right
     * @return
     */
    private int GetFirstIndex(int[] array, int k, int left, int right) {
        if (left > right)
            return -1;
        int mid = left + ((right - left) >> 1);
        if (array[mid] == k) {
            if (mid == left || (array[mid - 1] != k)) {
                return mid;
            } else {
                right = mid - 1;
            }
        } else if (array[mid] > k) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return GetFirstIndex(array, k, left, right);
    }

    /**
     * 先用二分查找找出某个k出现的位置，然后再分别向前和向后查找总的个数
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0 || array == null)
            return 0;
        int left = 0;
        int right = array.length - 1;
        int count = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;//若数组过大，防止溢出
            if (array[mid] == k) {
                count++;
                //判断前面是否还有等于k的元素
                if (mid > left) {
                    if (array[mid - 1] == k) {
                        for (int i = mid - 1; i >= 0; i--) {
                            if (array[i] == k) {
                                count++;
                            } else break;
                        }
                    }
                }
                //判断后面是否还有等于k的元素
                if (mid < right) {
                    if (array[mid + 1] == k) {
                        for (int i = mid + 1; i <= right; i++) {
                            if (array[i] == k) {
                                count++;
                            } else break;
                        }
                    }
                }
                return count;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }


    /**
     * 暴力
     *
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK_2(int[] array, int k) {
        if (array.length == 0 || array == null)
            return 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }
        }
        return count;
    }

}
