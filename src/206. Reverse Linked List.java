/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode tmp = cur.next; // 让tmp指向没有reverse过的最新的一个节点
            cur.next = tmp.next;     // 让cur指向节点与该新节点后面一个新节点相连（用于下一步更新tmp）
            tmp.next = dummy.next;   // 让tmp下一个点指向之前的头节点（即最新加入的节点的下一个点与之前reverse完的list相连，
			             // 完成到该新节点为止的reverse操作）
            dummy.next = tmp;        // 让dummy.next指向新的头节点（即最新的节点成为新的头节点）
        }
        return dummy.next;   
    }
}
