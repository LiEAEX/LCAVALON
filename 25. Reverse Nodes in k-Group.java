/**
开始pre指向-1，next指向4，带入子函数中，last指向3，cur指向2，在while循环中，先把3连上1，再把2连上3，再把-1连上2，将cur指向1，此时局部顺序为 -1->2->3->1->4，但此时cur还是跟next不同，所以while需要再循环一次。
此时last还是指向3，我们将3和4相连，再将1和2相连，再将-1和1相连，将cur指向4，此时局部顺序为 -1->1->2->3->4，此时cur跟next相同了，返回last，局部翻转完成
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
//一般在处理链表问题时，我们大多时候都会在开头再加一个dummy node，因为翻转链表时头结点可能会变化，为了记录当前最新的头结点的位置而引入的dummy node
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy, cur = head;
        dummy.next = head;
        int i = 0;
        while (cur != null) {
            ++i;
            if (i % k == 0) {
                pre = reverseOneGroup(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    ListNode reverseOneGroup(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while(cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
}