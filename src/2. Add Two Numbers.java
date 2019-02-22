/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

Runtime: 19 ms, faster than 99.90% of Java online submissions for Add Two Numbers.
Memory Usage: 48.3 MB, less than 14.25% of Java online submissions for Add Two Numbers.

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int c = 0;
        while (l1 != null && l2 != null){
            dummy.next = new ListNode((l1.val + l2.val + c)%10);
            c = l1.val + l2.val + c >= 10? 1: 0;
            l1 = l1.next;
            l2 = l2.next;
            dummy = dummy.next;
        }
        while (l1 == null && l2 != null){
            dummy.next = new ListNode((l2.val + c)%10);
            c = c + l2.val >= 10? 1: 0;
            l2 = l2.next;
            dummy = dummy.next;
        }
        while (l2 == null && l1 != null){
            dummy.next = new ListNode((l1.val + c)%10);
            c = c + l1.val >= 10? 1: 0;
            l1 = l1.next;
            dummy = dummy.next;
        }
        if (l1 == null && l2 == null && c == 1){
            dummy.next = new ListNode(1);
            return cur.next;
        }
        return cur.next;
    }
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(666);
        ListNode c = d;
        int carry = 0;//进位的初始化
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;//空值则d1为0，否则传入l1的值
            int d2 = l2 == null ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0;
            c.next = new ListNode(sum % 10);//写入该位计算结果
            c = c.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) c.next = new ListNode(1);
        return d.next;//输出第一个Node之后的全部Node(I guess, maybe...)
    }
}
