package LinkedList;

import java.util.HashMap;

/**
 * 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Solution22 {

    public ListNode FindFirstCommonNode_2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;

        int length1 = getLength(current1);
        int length2 = getLength(current2);
        //如果链表1的长度大于链表2的长度
        if (length1 >= length2) {
            int len = length1 - length2;
            //先遍历链表1，再遍历链表2，遍历的长度为两链表长度差
            while (len > 0) {
                current1 = current1.next;
                len--;
            }
        } else {//如果链表2的长度大于链表1的长度
            int len = length2 - length1;
            //先遍历链表2，再遍历链表1，遍历的长度为两链表长度差
            while (len > 0) {
                current2 = current2.next;
                len--;
            }
        }

        //遍历剩下节点，直到找到第一个公共节点
        while (current1 != current2) {
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1;
    }

    /**
     * 获取链表长度
     *
     * @param listNode
     * @return
     */
    private int getLength(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }

    /**
     * 先把pHead1放入HashMap中
     * 根据HashMap的containsKey方法，查询是否有相同的节点
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;

        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        while (current1 != null) {
            hashMap.put(current1, null);
            current1 = current1.next;
        }
        while (current2 != null) {
            if (hashMap.containsKey(current2)) {
                return current2;
            }
            current2 = current2.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
