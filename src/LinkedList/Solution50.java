package LinkedList;

/**
 * 链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution50 {

    /**
     * 设链表的长度为 N。设两个指针 fast 和 slow，先让 fast 移动 k-1 个节点，则还有 N - k 个节点可以移动。此时让 fast 和 slow 同时移动，可以知道当 fast 移动到链表结尾时，slow 移动到 N - k + 1 个节点处，该位置就是倒数第 k 个节点。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow;
        for (int i = 0; i < k - 1; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
