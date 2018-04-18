package String;

import java.util.BitSet;

/**
 * 第一个只出现一次的字符位置
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class Solution51 {
    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        String str = "eabbaecdffd";
        System.out.println(solution51.FirstNotRepeatingChar_2(str));
    }

    /**
     * 使用BitSet对出现次数进行统计    0,1,更多
     * 对应ASCII码表的256个字符
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar_2(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                bs1.set(c);     // 0 0
            } else if (bs1.get(c) && !bs2.get(c)) {
                bs2.set(c); // 0 1
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c))
                return i;
        }
        return -1;
    }

    /**
     * 使用整型数组对出现次数进行统计
     * 对应ASCII码表的256个字符
     * 数组的index就是字符, 值为字符出现的次数
     *
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++) cnts[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++) if (cnts[str.charAt(i)] == 1) return i;
        return -1;
    }
}
