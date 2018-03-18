package Stack;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 思路：
 * 用一个栈data保存数据，用另外一个栈min保存入栈最小的数
 */
public class Solution25 {

    Stack<Integer> date = new Stack<>();//存储数据
    Stack<Integer> min = new Stack<>();//存储最小值


    public void push(int node) {
        date.push(node);
        if (min.empty()) {
            min.push(node);
        } else {
            min.push((min.peek()) > node ? node : min.peek());//min栈顶始终是最小值
        }
    }

    public void pop() {
        date.pop();
        min.pop();
    }

    public int top() {
        return date.peek();
    }

    public int min() {
        return min.peek();
    }
}
