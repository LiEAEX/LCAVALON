Runtime: 7 ms, faster than 34.77% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
Memory Usage: 34 MB, less than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.


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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}