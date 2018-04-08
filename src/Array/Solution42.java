package Array;

import java.util.HashMap;

/**
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution42 {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(solution42.MoreThanHalfNum_Solution_2(array));
    }

    /**
     * 利用 Boyer-Moore Majority Vote Algorithm（摩尔投票算法）来解决这个问题
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution_2(int[] array) {
        int majority = array[0];
        for (int i = 1, count = 1; i < array.length; i++) {
            count = array[i] == majority ? count + 1 : count - 1;
            if (count == 0) {
                majority = array[i];
                count = 1;
            }
        }
        int count = 0;
        for (int val : array) if (val == majority) count++;
        return count > array.length / 2 ? majority : 0;
    }

    /**
     * 利用HashMap记录每个数字以及数字出现的次数
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count;
        for (int val :
                array) {
            if (!map.containsKey(val)) {
                map.put(val, 1);
            } else {
                count = map.get(val);
                map.put(val, ++count);
            }
            if (map.get(val) > array.length / 2) {
                return val;
            }
        }
        return 0;
    }
}
