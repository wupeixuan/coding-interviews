package Recursion;

import java.util.Arrays;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution05 {
    public static void main(String[] args) {
        Solution05 solution05 = new Solution05();
        System.out.println(solution05.JumpFloorII_3(3));

    }

    /**
     * 动态规划
     *
     * @param target
     * @return
     */
    public int JumpFloorII_3(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }

    /**
     * 用递归求解
     * f(n) = f(n-1) + f(n-2) + ... + f(1)
     * f(n-1) = f(n-2) + ... + f(1)
     * f(n) = 2*f(n-1)
     *
     * @param target 台阶数
     * @return 跳法
     */
    public int JumpFloorII(int target) {
        if (target <= 1) {
            return 1;
        } else if (target <= 2) {
            return 2;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }

    /**
     * f(n)=2^(n-1)
     *
     * @param target 台阶数
     * @return
     */
    public int JumpFloorII_2(int target) {
        //通过移位计算2的次方
        return 1 << (target - 1);
    }


}
