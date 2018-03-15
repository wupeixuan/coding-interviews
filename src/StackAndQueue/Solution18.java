package StackAndQueue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路：
 * 栈A用来作入队列，栈B用来出队列
 * 当栈B为空时，栈A全部出栈到栈B,栈B再出栈（即出队列）
 */
public class Solution18 {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        solution18.push(1);
        solution18.push(2);
        System.out.println(solution18.pop());
        solution18.pop();
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);//stack1负责入队
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("队列为空");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();//stcak2负责出队
    }
}
