/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        
        return sumRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int sumRoot(TreeNode root, int sum){
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) res++;
        res = res + sumRoot(root.left, sum - root.val) + sumRoot(root.right, sum - root.val);
        return res;
    }
}