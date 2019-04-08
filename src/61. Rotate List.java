Runtime: 1 ms, faster than 89.35% of Java online submissions for Rotate List.
Memory Usage: 38.3 MB, less than 9.81% of Java online submissions for Rotate List.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        
        int len = listLen(head, head);
        int move = k % len;
        int moveHelper = len - move;

        ListNode cur = head;        
        while (moveHelper > 1){
            cur = cur.next;
            moveHelper--;
        }
        ListNode newHead = cur.next;
        cur.next = null;

        return newHead;
    }
    
    private int listLen(ListNode root, ListNode head){
        int cnt = 0;
        while (root != null){
            cnt++;
            if (root.next == null){
                root.next = head;
                break;
            }
            root = root.next;
        }
        return cnt;
    }
}