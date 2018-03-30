package Array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class Solution34 {
    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] array = {1, 2, 3, 4, 5, 6};
        int sum = 5;
        System.out.println(solution34.FindNumbersWithSum_2(array, sum));

    }

    /**
     * 两头夹逼
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                result.add(array[left]);
                result.add(array[right]);
                break;
            } else if (array[left] + array[right] > sum) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    /**
     * 用HashMap存放元素和下标，然后开始遍历数组找到和为sum的两个元素，从左到右找到的第一对和为sum的就是最小的一对。
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum_2(int[] array, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            map.put(array[i], i);
        }
        for (int i = 0; i < len; i++) {
            int sub = sum - array[i];
            if (map.containsKey(sub)) {
                result.add(array[i]);
                result.add(sub);
                break;
            }
        }
        return result;
    }
}

