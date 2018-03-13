package String;

/**
 * 替换空格
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(solution12.replaceSpace_3(str));


    }

    /**
     * 新建字符串，遍历原字符串，当发现空格时，在新字符串添加%20，否则添加原字符串中的数据，改变原数据
     *
     * @param str
     * @return
     */
    public String replaceSpace_3(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == (' ')) {
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            } else {
                newStr.append(str.charAt(i));
            }

        }
        return newStr.toString();

    }

    /**
     * 直接把StringBuffer转换成String调用replaceAll方法，改变原数据
     *
     * @param str
     * @return
     */
    public String replaceSpace_2(StringBuffer str) {
        if (str == null) {
            return null;
        }
        return str.toString().replaceAll(" ", "%20");

    }

    /**
     * 遍历字符串，当发现空格时，替换空格，改变原数据
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int i = 0, j;
        while (i < str.length()) {
            if ((j = str.indexOf(" ")) != -1) {
                str.replace(j, j + 1, "%20");
                i += 2;
            }
            i++;
        }
        return str.toString();
    }
}
