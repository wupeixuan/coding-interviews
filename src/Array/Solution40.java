package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution40 {
    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();

        ArrayList<ArrayList<Integer>> lists = solution40.FindContinuousSequence_2(100);
        for (ArrayList<Integer> list :
                lists) {
            System.out.println(list);
        }
    }

    /**
     * 等差数列Sn=(a1+an)*n/2   n=an-a1+1 Sn=(a1+an)*(an-a1+1)/2
     * 初始化left=1，big=2;
     * left到right序列和小于sum，right++;大于sum，left++;
     * 当left增加到(1+sum)/2是停止
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence_2(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (sum < 3)
            return result;
        ArrayList<Integer> list;
        int left = 1;
        int right = 2;
        int total = 0;
        while (left < right && left < (1 + sum) / 2) {
            total = (left + right) * (right - left + 1) / 2;
            if (total == sum) {
                list = new ArrayList<Integer>();
                int temp = left;
                while (temp <= right) {
                    list.add(temp);
                    temp++;
                }
                result.add(list);
                left++;
                right++;
            } else if (total < sum) {
                right++;
            } else {
                left++;
            }
        }
        return result;
    }

    /**
     * 暴力
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= sum / 2; i++) {
            list.add(i);
            for (int j = i + 1; j <= sum / 2 + 1; j++) {
                list.add(j);
                int total = 0;
                for (int x = 0; x < list.size(); x++) {
                    total += list.get(x);
                }
                if (total == sum) {
                    result.add(list);
                    list = new ArrayList<Integer>();
                    break;
                } else if (total > sum) {
                    list.clear();
                    break;
                }
            }
        }
        return result;
    }
}
