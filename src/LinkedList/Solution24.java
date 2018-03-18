package LinkedList;

import java.util.HashSet;

/**
 * 链表中环的入口结点
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class Solution24 {

    /**
     * 假设x为环前面的路程，a为环入口到相遇点的路程， c为环的长度
     * 当快慢指针相遇的时候： 此时慢指针走的路程为Sslow = x + m * c + a
     * 快指针走的路程为Sfast = x + n * c + a
     * 2 Sslow = Sfast
     * 2 * ( x + m*c + a ) = (x + n *c + a)
     * 从而可以推导出： x = (n - 2 * m )*c - a = (n - 2 *m -1 )*c + c - a
     * 即环前面的路程 = 数个环的长度（为可能为0） + c - a
     * 什么是c - a？这是相遇点后，环后面部分的路程。
     * 所以，我们可以让一个指针从起点A开始走，让一个指针从相遇点B开始继续往后走， 2个指针速度一样，
     * 那么，当从原点的指针走到环入口点的时候（此时刚好走了x） 从相遇点开始走的那个指针也一定刚好到达环入口点。
     * 所以两者会相遇，且恰好相遇在环的入口点。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop_2(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null)
            return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        //先判断有没有环
        while (fast != slow) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                //没有环
                return null;
            }
        }

        fast = pHead;//把fast指向头节点
        //有环
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 利用HashSet元素不能重复
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (pHead != null) {
            if (!hashSet.add(pHead)) {
                return pHead;
            }
            pHead = pHead.next;
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
