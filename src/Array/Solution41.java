package Array;

/**
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution41 {
    public static void main(String[] args) {
        Solution41 solution41 = new Solution41();
        char[] str = {'5', 'e', '2'};
        System.out.println(solution41.isNumeric_3(str));
    }

    public boolean isNumeric_3(char[] str) {
        // 标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1) return false; // e后面一定要接数字
                if (hasE) return false; // 不能同时存在两个e
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                sign = true;
            } else if (str[i] == '.') {
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') // 不合法字符
                return false;
        }
        return true;
    }

    /**
     * 系统自身的校验机制
     *
     * @param str
     * @return
     */
    public boolean isNumeric_2(char[] str) {
        try {
            double number = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * 利用正则表达式
     * [\\+\\-]?                 正或负符号出现与否
     * \\d*                      整数部分是否出现，如-.34 或 +3.34均符合
     * (\\.\\d+)?                如果出现小数点，那么小数点后面必须有数字；否则一起不出现
     * ([eE][\\+\\-]?\\d+)?      如果存在指数部分，那么e或E肯定出现，+或-可以不出现，紧接着必须跟着整数；或者整个部分都不出现
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        return new String(str).matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
}
