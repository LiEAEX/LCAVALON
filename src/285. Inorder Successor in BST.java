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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        
        TreeNode res = null;
        Stack<TreeNode> s = new Stack<>();
        while (root != null){
            if (root.val < p.val){
                root = root.right;
            }
            else if (root.val > p.val){
                s.push(root);
                root = root.left;
            }
            else if (root.val == p.val){
                if (root.right != null){
                    s.push(root.right);
                    root = root.right;
                } 
                else if (root.right == null){
                    break;
                }
            }
        }
        if (!s.isEmpty()) res = s.pop();
        return res;
    }
}


Recursion:
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }
}

Code walkthrough for Successor:

First we go to exact path of node till end which we want to find out using BST property.
Use back track, Consideration for every node while back track
(a). For every node if we backtrack from right side then simply return because successor will be its parent.
(b). If we backtrack from left side, then successor will be Either current node OR any successor found in left subtree.