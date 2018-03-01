/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Solution07 {
    public static void main(String[] args) {
        Solution07 solution07 = new Solution07();
        System.out.println(solution07.Power(1, -4));
    }

    /**
     * 使用累乘
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double result = 1;
        if (exponent < 0) {
            if (base < 1 / 1.7E308 && base > -1 / 1.7E308)
                throw new RuntimeException("分母不能为0");
            for (int i = 0; i < -exponent; i++) {
                result = result * base;
            }
            return 1 / result;
        } else {
            for (int i = 0; i < exponent; i++) {
                result = result * base;
            }
            return result;
        }
    }

}
