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
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }
    
    private void dfs(TreeNode root, int sum){
        if (root != null){
            sum = sum - root.val;
            if (sum == 0 && root.left == null && root.right == null){
                res = true;
                return;
            }
            dfs(root.left, sum);
            dfs(root.right, sum);
        }
    }
}