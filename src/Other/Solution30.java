package Other;

import java.util.LinkedList;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,
 * 继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 思路：
 * 约瑟夫环问题
 */
public class Solution30 {
    /**
     * 记录一下其中映射关系的由来：
     * n个人排成一排，编号如下：
     * 0,1,2,3,4，.....,n-2,n-1
     * 按照规定，第一个出队的人的编号是 k = (m-1)%n,(对n取余是考虑到m>n的情况)，记最后剩下的人的编号为 F(n, m)
     * 接下来从编号为k+1的人开始报数，相当于如下的编号排列：
     * k+1, k+2, k+3, ...., n-2, n-1, 0, 1, ..., k-2, k-1  ////(*)
     * 对应的映射为：
     * 0, 1, 2, .....,n-k-3, n-k-2, n-k-1, n-k, ...., n-3, n-2  /////(**)
     * 描述这个映射关系的函数为：
     * p(x) = (x+n-k-1)%n, 这里的变量x表示上面数列（*）的元素，p(x) 表示上面数列（**）中相同位置对应的值
     * 然后我们实际上需要的映射是描述 (**)--->(*) 的函数，即为p^(x)
     * 如果找到这样的映射p^(x)，则F(n-1,m)可以通过p^(x)映射到(*)中，即跟F(n, m)建立联系。
     * 因为p(x) = (x+n-k-1)%n,根据取余运算的定义，它等价于 x+n-k-1 = g*n + p(x)，其中g表示某个整数
     * 等式左边移位化简后得：x = (g-1)*n + p(x) + k + 1
     * 注意x代表的是上面数列(*)中的编号，因此x的取值范围为[0,n-1],因此上面的等式需要对n取余，即：
     * x = [(g-1)*n + p(x) + k + 1]%n = [p(x) + k + 1]%n
     * 改写因变量和自变量得到：p^(x) = [x+k+1]%n
     * 上式中的x代表(**)数列中的元素，也即F(n-1,m),将 x = F(n-1, m) 和 k = (m-1)%n 代入即得：
     * F(n, m) = [ F(n-1, m) + (m-1)%n + 1 ]%n
     * 继续化简上式： 由 k=(m-1)%n 得 m-1=j*n+k,得 k = m-1-j*n = (m-1)%n，代入上式：
     * F(n, m) = [ F(n-1, m) + m-1-j*n + 1 ]%n = [ F(n-1, m) + m ]%n
     * 注意 [-j*n]%n = 0
     * 因此递归关系表达式为：F(n, m) = [F(n-1, m)+m]%n 
     */
    public int LastRemaining_Solution_2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return ((LastRemaining_Solution_2(n - 1, m) + m) % n);
    }

    /**
     * LinkedList增删节点效率比较高
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        LinkedList<Integer> linkedList = new LinkedList();

        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }

        int temp = 0;
        while (linkedList.size() > 1) {
            temp = (temp + m - 1) % linkedList.size();//temp为每次出列的人
            linkedList.remove(temp);
        }
        return linkedList.size() == 1 ? linkedList.get(0) : -1;
    }
}
