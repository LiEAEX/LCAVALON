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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean res = false;
        if (p == null && q == null) return true;
        if ((p == null && q != null)||(q == null && p != null)) return false;
        while (p != null && q != null && p.val == q.val){
            res = isSameTree(p.left, q.left);
            if (res == false) break;
            res = isSameTree(p.right, q.right);
            return res;
        }
        return res;
    }    
}

// Reference
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;
    if(p.val == q.val)
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    return false;
}
