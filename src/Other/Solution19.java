package Other;

/**
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution19 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        System.out.println(solution19.NumberOf1_3(3));
    }

    public int NumberOf1_3(int n) {
        return Integer.bitCount(n);
    }

    /**
     * 如果一个整数不为0，那么这个整数至少有一位是1。
     * 如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。
     * 其余所有位将不会受到影响。
     *
     * @param n
     * @return
     */
    public int NumberOf1_2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    /**
     * 用flag来与n的每位做位于运算，来判断1的个数
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((flag & n) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
