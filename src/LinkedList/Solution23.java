package LinkedList;

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution23 {

    public ListNode deleteDuplication_2(ListNode pHead) {
        // 设置一个节点指向头结点
        ListNode first = new ListNode(-1);
        first.next = pHead;
        // last指针永远指向移动前的扫到的最后一个节点
        ListNode last = first;
        while (pHead != null && pHead.next != null) {
            if (pHead.val == pHead.next.val) {
                int val = pHead.val;
                while (pHead != null && pHead.val == val)
                    pHead = pHead.next;
                last.next = pHead;
            } else {
                last = pHead;
                pHead = pHead.next;
            }
        }
        return first.next;
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        // 只有0个或1个结点，则返回
        if (pHead == null || pHead.next == null)
            return pHead;
        // 当前结点是重复结点
        if (pHead.val == pHead.next.val) {
            ListNode listNode = pHead.next;
            while (listNode != null && listNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                listNode = listNode.next;
            }
            return deleteDuplication(listNode);// 从第一个与当前结点不同的结点开始递归
        } else {// 当前结点不是重复结点
            // 保留当前结点，从下一个结点开始递归
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


}
