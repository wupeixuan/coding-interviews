package LinkedList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;


/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class Solution10 {


    /**
     * 从尾到头打印，很明显先进后出，利用栈，栈先进后出
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {
        if (listNode == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            return arrayList;
        }
        //定义一个栈
        Deque<Integer> stack = new ArrayDeque<>();
        while (listNode != null) {
            stack.push(listNode.val);//入栈
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());//出栈，并添加到arrayList
        }
        return arrayList;
    }

    ArrayList<Integer> arrayList = new ArrayList<>();

    /**
     * 递归方法
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;

    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
 

