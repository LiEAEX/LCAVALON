/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode help = new ListNode(-1);
        dummy.next = head;
        while (head != null && head.next != null){
            help = head;
            while (help.next != null && head.val == help.next.val){
                help = help.next;
                head.next = help.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}