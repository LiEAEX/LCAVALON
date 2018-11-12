/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode a = new ListNode(-1), cur = a;
        while (l1 != null && l2 != null) {
            if (l1.val<l2.val){
            cur.next = l1;
            l1 = l1.next;
            }else{
            cur.next = l2;
            l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 != null)? l1 : l2;
        return a.next;
     }
}
/* 新建一个链表，然后比较两个链表中的元素值，
把较小的那个链到新链表中，由于两个输入链表的长度可能不同，
所以最终会有一个链表先完成插入所有元素，
这样就直接把另一个未完成的链表链入新链表的末尾*/