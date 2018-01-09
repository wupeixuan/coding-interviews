package DiGui;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 * 思路：
 * 在数学上，斐波纳契数列以如下被以递归的方法定义：F0=0，F1=1，Fn=F(n-1)+F(n-2)（n>=2，n∈N*）
 * 用文字来说，就是斐波那契数列列由 0 和 1 开始，之后的斐波那契数列系数就由之前的两数相加。
 * 特别指出：0不是第一项，而是第零项。
 */
public class Solution03 {
    public static void main(String[] args) {
        System.out.println(Fibonacci_2(4));
    }

    /**
     * 用递归直接求解
     * @param n 斐波那契数列第n项
     * @return 斐波那契数列第n项的值
     */
    public static int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 1) {
            return n;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }

    /**
     * 迭代方法，用两个变量记录fn-1和fn-2:
     * @param n 斐波那契数列第n项
     * @return fN 斐波那契数列第n项的值
     */
    public static int Fibonacci_2(int n) {
        int zero = 0, one = 1, fN = 0;
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            //由zero和one保存中间结果
            for (int i = 2; i <= n; i++) {
                fN = one + zero;
                zero = one;
                one = fN;
            }
            return fN;
        }
    }
}
