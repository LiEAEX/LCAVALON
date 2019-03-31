/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
O(n^2):

class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (checkBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE)) return countHelper(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    private boolean checkBST(TreeNode root, int max, int min){
        if (root == null) return true;
        if (root.val > min && root.val < max){
            return checkBST(root.left, root.val, min) && checkBST(root.right, max, root.val);
        }
        else return false;
    }
    
    private int countHelper(TreeNode root){
        if (root == null) return 0;
        return 1 + countHelper(root.left) + countHelper(root.right);
    }
}

O(n):

class Solution {
    // return array for each node: 
    //     res[0] --> min
    //     res[1] --> max
    //     res[2] --> largest BST in its subtree(inclusive)
    public int largestBSTSubtree(TreeNode root) {
        int[] res = countBST(root);
        return res[2];
    }
    
    private int[] countBST(TreeNode root){
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = countBST(root.left);
        int[] right = countBST(root.right);
        if (root.val < right[0] && root.val > left[1]){
            return new int[]{Math.min(root.val, left[0]), Math.max(root.val, right[1]), 1 + left[2] + right[2]};
        } 
        else return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])}; 
        说明现在node不是一个BST，这样设置min和max之后，（root.val < right[0] && root.val > left[1] ）会对这个点不成立，递归到此停止返回值       
    }
}

When node==null we return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; 
since when one node is null, every parent node still can form a BST 
(node.val > left[1] && node.val < right[0] this condition can be satisfied later on

However, when a current subtree is not valid BST (else part) 
then we return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])}
since no parent subtree can be BST if one child subtree is not valid BST. 
By setting like that this condition node.val > left[1] && node.val < right[0] will never be satisfied later on