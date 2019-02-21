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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
    
    private int helper(TreeNode node){
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        res = Math.max(res, node.val + left + right);
        int temp = node.val + Math.max(left, right);
        return temp > 0? temp:0;
    }
}


int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        backtrack(root);
        return max;
    }
    private int backtrack(TreeNode root){
        if(root == null) return 0;
        int leftSum = Math.max(0, backtrack(root.left));//less than 0, then not take left branch
        int rightSum = Math.max(0, backtrack(root.right));//less than 0, then not take right branch 
        max = Math.max(max,leftSum + rightSum + root.val);//root,left + root, right + root, left + right + root;
        return Math.max(0,Math.max(root.val + leftSum,root.val + rightSum));//take left+root or right+root or root or 0
    }