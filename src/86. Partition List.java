/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(-1); 
        ListNode cur1 = res;
        ListNode temp = new ListNode(-1); 
        ListNode cur2 = temp;
        //res.next = head;
        
        while (head != null){
            if (head.val >= x){
                temp.next = new ListNode(head.val);
                temp = temp.next;
                head = head.next;
            }
            else if (head.val < x){  这里必须用 else if, 如果用 if，每次 while 循环会执行所有判断语句，如果没有 x 比 head.val 大，则此处会报错，NullPointerException
                res.next = new ListNode(head.val);
                res = res.next;
                head = head.next;
            }
        }
        
        if (cur2.next != null) res.next = cur2.next;
        return cur1.next;
    }
}