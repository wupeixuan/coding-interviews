package String;

import java.util.Stack;

/**
 * 翻转单词顺序列
 */
public class Solution56 {
    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        String str = "student. a am I";
        System.out.println(solution56.ReverseSentence(str));
    }

    /**
     * 单词依次入栈出栈实现反转
     *
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if ("".equals(str.trim()) || str.length() == 0 || str == null) {
            return str;
        }
        String[] split = str.trim().split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            stack.push(split[i]);
        }
        String res = stack.pop();
        while (!stack.isEmpty()) {
            res += " " + stack.pop();
        }
        return res;
    }
}
