/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode d = new ListNode(-1);
        ListNode c = d;
        d.next = head;
        while (c.next!=null && c.next.next!=null){
            ListNode t = c.next.next;
            c.next.next = t.next;
            t.next = c.next;
            c.next = t;
            c = t.next;
        }
        return d.next;
    }
}