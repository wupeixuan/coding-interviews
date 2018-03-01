package DiGui;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 思路：
 * 当n=1，f（n）=1
 * 当n=2，f（n）=2
 * 当n>2时，当第一个小矩形横着放时，摆法有f(n-1)
 * 当第一个小矩形竖着放时，摆法有f(n-2)
 * f(n)=f(n-1)+f(n-2)
 */
public class Solution06 {
    public static void main(String[] args) {
        Solution06 solution06 = new Solution06();
        System.out.println(solution06.RectCover(5));
    }

    /**
     * 用递归的方法
     *
     * @param target n
     * @return 摆法
     */
    public int RectCover(int target) {
        int sum;
        if (target < 1) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            sum = RectCover(target - 1) + RectCover(target - 2);
            return sum;
        }
    }

    /**
     * 迭代的方法
     *
     * @param target
     * @return
     */
    public int RectCover_2(int target) {
        int a = 1, b = 2, c = 0;
        if (target < 1) {
            return 0;
        } else if (target <= 2) {
            return target;
        } else {
            for (int i = 0; i < target - 2; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}
