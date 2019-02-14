Runtime: 1 ms, faster than 100.00% of Java online submissions for Intersection of Two Linked Lists.
Memory Usage: 36 MB, less than 100.00% of Java online submissions for Intersection of Two Linked Lists.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
Three steps: 1) calculate length difference 2) move one node N steps forward to reach the same length 3) move nodeA, move nodeB at the same time.
Time complexity is O(2m + 2n)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = calcLen(headA);
        int lenB = calcLen(headB);
        if(lenA > lenB){
            headA = moveNStep(headA,lenA-lenB);
        }else headB = moveNStep(headB, lenB - lenA);
        while(headA != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    private ListNode moveNStep (ListNode node,int n){
        while( n!= 0){
            node = node.next;
            n--;
        }
        return node;
    }
    private int calcLen (ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}