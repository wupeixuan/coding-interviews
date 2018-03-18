package String;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字符流中第一个不重复的字符
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * 思路：
 * 使用一个LinkedHashMap来统计字符出现的次数
 */
public class Solution26 {

    Map<Character, Integer> linkedHashMap = new LinkedHashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (linkedHashMap.containsKey(ch)) {
            linkedHashMap.put(ch, linkedHashMap.get(ch) + 1);
        } else {
            linkedHashMap.put(ch, 1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        //遍历map集合，判断出现次数是否为1
        for (Map.Entry<Character, Integer> entry :
                linkedHashMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '#';
    }
}

