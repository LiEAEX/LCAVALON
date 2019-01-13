/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || SymmetricHelper(root.left, root.right);
    }
    
    public boolean SymmetricHelper(TreeNode r1, TreeNode r2){
        if (r1 == null || r2 == null) return r1 == r2;
        if (r1.val != r2.val) return false;
        return SymmetricHelper(r1.left, r2.right) && SymmetricHelper(r1.right, r2.left);
    }
}