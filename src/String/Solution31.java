package String;

/**
 * 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Solution31 {
    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        String str = "abcXYZdef";
        System.out.println(solution31.LeftRotateString(str, 3));
    }

    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) return "";
        StringBuilder sb1 = new StringBuilder(str.substring(0, n));
        StringBuilder sb2 = new StringBuilder(str.substring(n, str.length()));
        sb2.append(sb1);
        return sb2.toString();
    }
}
