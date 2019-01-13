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
    public boolean isBalanced(TreeNode root) {
        boolean res = false;
        if (root == null) return true;
        int leftdepth = 0, rightdepth = 0;
        leftdepth = maxDepth(root.left);
        rightdepth = maxDepth(root.right);
        if (Math.abs(leftdepth - rightdepth) < 2 && isBalanced(root.left) && isBalanced(root.right)) res = true;
        return res;
    }
    
    private int maxDepth(TreeNode root){
        if (null == root) {
            return 0;
        } else {
            int i = maxDepth(root.left);
            int j = maxDepth(root.right);
            return (j > i) ? j + 1 : i + 1;
        }
    }
}