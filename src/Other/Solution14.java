package Other;

/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 思路：位运算
 * 1.两个数异或：相当于每一位相加，而不考虑进位；
 * 2.两个数相与，并左移一位：相当于求得进位；
 * 3.将上述两步的结果相加
 */
public class Solution14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.Add_4(2, -3));

    }

    /**
     * 自增自减
     *
     * @param num1
     * @param num2
     * @return
     */
    public int Add_4(int num1, int num2) {
        if (num1 < 0) {
            while (num1++ != 0) {
                num2--;
            }
        } else if (num1 > 0) {
            while (num1-- != 0) {
                num2++;
            }
        }
        return num2;
    }

    /**
     * 调用Integer的sum方法
     *
     * @param num1
     * @param num2
     * @return
     */
    public int Add_3(int num1, int num2) {
        return Integer.sum(num1, num2);
    }

    /**
     * 递归
     *
     * @param num1
     * @param num2
     * @return
     */
    public int Add_2(int num1, int num2) {
        if (num2 == 0)
            return num1;
        return Add(num1 ^ num2, (num1 & num2) << 1);
    }

    /**
     * 位运算
     *
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;//执行加法
            num2 = (num1 & num2) << 1;//进位操作
            num1 = temp;
        }
        return num1;
    }
}
