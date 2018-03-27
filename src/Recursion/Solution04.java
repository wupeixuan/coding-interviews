package Recursion;

/**
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution04 {
    public static void main(String[] args) {
        Solution04 solution04 = new Solution04();
        System.out.println(solution04.JumpFloor_3(3));

    }

    /**
     * 动态规划
     *
     * @param target
     * @return
     */
    public int JumpFloor_3(int target) {
        if (target == 1) return 1;
        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target - 1];
    }


    /**
     * 直接用递归
     * 对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来，所以
     * F(n) = F(n-1) + F(n-2)
     * f(1)=1
     * f(2)=2
     *
     * @param target 台阶数
     * @return 跳法
     */
    public int JumpFloor(int target) {
        if (target <= 1) {
            return 1;
        }
        if (target <= 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }

    /**
     * 用迭代的方法，用两个变量记录f(n-1) f(n-2)
     *
     * @param target 台阶数
     * @return 跳法
     */
    public int JumpFloor_2(int target) {
        int one = 1, two = 2, fN = 0;
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            for (int i = 3; i <= target; i++) {
                fN = one + two;
                one = two;
                two = fN;
            }
            return fN;
        }
    }
}
