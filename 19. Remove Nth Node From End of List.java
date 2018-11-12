/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode fast = dummy, slow = dummy;//执行这两句后，fast，slow和dummy都指向了同一个地址区间
        dummy.next = head;//head是头结点
        for(int i = 0; i < n+1; i++) fast = fast.next;//fast = fast.next是把fast指针指向下一个结点，并没有改变dummy指针指向的地址
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;//slow.next = slow.next.next的作用是将slow结点后面的那个结点移除，就是slow的next指针跳过一个结点，连到下一个结点
        return dummy.next;
        
    }
}