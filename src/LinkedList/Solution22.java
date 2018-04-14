package LinkedList;

import java.util.HashMap;

/**
 * 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Solution22 {

    /**
     * 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
     * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode_3(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

    /**
     * 找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
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
