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
        if (root == null) return true;
        return checkSymmetric(root.left, root.right);
    }
    
    public boolean checkSymmetric(TreeNode a, TreeNode b){
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return checkSymmetric(a.left, b.right) && checkSymmetric(a.right, b.left);
    }
}



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
