/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
Runtime: 2 ms, faster than 50.82% of Java online submissions for Palindrome Linked List.
Memory Usage: 45.2 MB, less than 100.00% of Java online submissions for Palindrome Linked List.

Recursion:
class Solution {
    ListNode ref;    
    public boolean isPalindrome(ListNode head) {
        ref = head;        
        return check(head);
    }
    
    public boolean check(ListNode node){
        if(node == null) return true;
        boolean ans = check(node.next); 
        boolean isEqual = (ref.val == node.val)? true : false; 
        ref = ref.next;
        return ans && isEqual;
    }
}

explanation: compare value of node in the following orders:(ref.val == node.val) first 1 last 1, first 2 last 2...... 


Runtime: 473 ms, faster than 1.27% of Java online submissions for Palindrome Linked List.
Memory Usage: 43.8 MB, less than 100.00% of Java online submissions for Palindrome Linked List.

Origin:
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        boolean res = true;
        
        List<Integer> list = new LinkedList();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        //Integer a = -129, b = -129;
        //System.out.println(a.equals(b));
        int len = list.size();
        for (int i = 0; i < list.size(); i++){
            Integer a = list.get(i), b = list.get(len - 1);
            if (!a.equals(b)){
                res = false;
                break;
            }
            len--;
            if (i == len || i == len - 1) break;
        }
        
        return res;
    }
}