package DiGui;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来，所以
 * F(n) = F(n-1) + F(n-2)
 * f(1)=1
 * f(2)=2
 */
public class Solution04 {
    public static void main(String[] args) {
        System.out.println(JumpFloor_2(3));

    }

    /**
     * 直接用递归
     *
     * @param target 台阶数
     * @return 跳法
     */
    public static int JumpFloor(int target) {
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
    public static int JumpFloor_2(int target) {
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
