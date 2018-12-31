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
    public boolean isUnivalTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int a = root.val;
        boolean res = true;
        while(true){
             while(root != null){
                 if (a != root.val){
                     res = false;
                     break;
                 }
                 stack.push(root);
                 root = root.left;
             }
             if (stack.isEmpty()) break;
             root = stack.pop();
             root = root.right;
        }
        return res;
    }

}