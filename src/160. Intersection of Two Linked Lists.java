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



Runtime: 1 ms, faster than 97.52% of Java online submissions for Intersection of Two Linked Lists.
Memory Usage: 42.5 MB, less than 5.71% of Java online submissions for Intersection of Two Linked Lists.
    
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        
        int len1 = 0, len2 = 0;
        
        while (cur1 != null){
            cur1 = cur1.next;
            len1++;
        }
        
        while (cur2 != null){
            cur2 = cur2.next;
            len2++;
        }
        
        cur1 = headA;
        cur2 = headB;
        
        while (len1 > len2){
            cur1 = cur1.next;
            len1--;
        }
        
        while (len2 > len1){
            cur2 = cur2.next;
            len2--;
        }
        
        while (cur1 != null && cur2 != null){
            if (cur1.val == cur2.val && cur1 == cur2) return cur1; // must check if cur1 and cur2 point to the same address
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        
        return null;
    }
}
