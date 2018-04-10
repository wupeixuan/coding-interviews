package Array;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution46 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int[] numbers = {3, 32, 321};
        System.out.println(solution46.PrintMinNumber(numbers));

    }

    public String PrintMinNumber(int[] numbers) {
        String[] str = new String[numbers.length];
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        for (int i = 0; i < numbers.length; i++) {
            s.append(str[i]);
        }
        return String.valueOf(s);
    }
}
