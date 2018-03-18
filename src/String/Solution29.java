package String;

/**
 * 把字符串转换成整数
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * +2147483647
 * 1a33
 * 输出
 * 2147483647
 * 0
 */
public class Solution29 {
    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        String s1 = "+2147483647";
        String s2 = "1a33";
        System.out.println(solution29.StrToInt(s2));

    }

    /**
     * 判断字符串为空，长度为0,判断字符串转换后上下界是否溢出
     *
     * @param str
     * @return
     */
    public int StrToInt_2(String str) {
        //判断字符串是否为空，长度是否为0
        if (str == null || str.length() == 0) {
            return 0;
        }
        int start;
        int tag;//1表示+ 0表示-
        if (str.charAt(0) == '+') {
            start = 1;
            tag = 1;
        } else if (str.charAt(0) == '-') {
            start = 1;
            tag = 0;
        } else {
            start = 0;
            tag = 1;
        }
        long result = 0;
        for (int i = start; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp >= '0' && temp <= '9') {
                result = result * 10 + (temp - '0');
                if (tag == 1 && result > Integer.MAX_VALUE) throw new RuntimeException("上溢出");
                if (tag == 0 && result < Integer.MIN_VALUE) throw new RuntimeException("下溢出");
            } else {
                return 0;
            }
        }

        if (tag == 0) {
            return (int) (-1 * result);
        } else {
            return (int) result;
        }
    }

    public int StrToInt(String str) {
        int res = 0;
        try {
            res = Integer.valueOf(str);
        } catch (NumberFormatException e) {
            res = 0;
        }
        return res;
    }


}
