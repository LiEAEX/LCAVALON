/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
Memory Usage: 40.1 MB, less than 5.91% of Java online submissions for Validate Binary Search Tree.

class Solution {
    public boolean isValidBST(TreeNode root) {   
        
        return checkValid(root, null, null);        
    }
    
    private boolean checkValid(TreeNode root, Integer min, Integer max){
        if (root == null) return true;
        if (max != null && root.val >= max) return false;
        if (min != null && root.val <= min) return false;
        
        return checkValid(root.left, min, root.val) && checkValid(root.right, root.val, max);
    }
}