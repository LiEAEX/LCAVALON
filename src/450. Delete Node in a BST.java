Runtime: 3 ms, faster than 98.80% of Java online submissions for Delete Node in a BST.
Memory Usage: 40.8 MB, less than 55.34% of Java online submissions for Delete Node in a BST.

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val > key) root.left = deleteNode(root.left, key);
        else if (root.val < key) root.right = deleteNode(root.right, key);
        else { // root.val == key, find the node to be deleted
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            // node with two children, replace with the inOrder successor(minVal) in the right subtree
            root.val = getMin(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    
    private int getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
