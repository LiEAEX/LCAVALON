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
    List<Integer> nodes = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        if(root == null) return nodes;
        nodes.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
    
        return nodes;
    }
    
    public void leftBoundary(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        nodes.add(root.val);
        if(root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }
    public void rightBoundary(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) return;
        if(root.right == null)rightBoundary(root.left);
        else rightBoundary(root.right);
        nodes.add(root.val); // add after child visit(reverse)
    }
    public void leaves(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}



class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        if(root!=null){
            ls.add(root.val);
            lookupElems(root.left,ls,true,false);      
            lookupElems(root.right,ls,false,true);
        }
        return ls;
    }
    
    private void lookupElems(TreeNode root,List<Integer> ls,boolean isLeftBoundary,boolean isRightBoundary){
        if (root==null) return;
        
        // add leaf
        if (root.left==null && root.right==null) {
            ls.add(root.val);
            return;
        } 
        
        // left boundary
        if (isLeftBoundary) {
            ls.add(root.val);
            lookupElems(root.left,ls,root.left!=null,false);
            lookupElems(root.right,ls,root.left==null,false); 
            // only if root.left ==null, we can try to use the root.right as the left boundary
            // otherwise it will return nothing
            return;
        }
        
        // leaf check
        if (!isLeftBoundary && !isRightBoundary){
            lookupElems(root.left,ls,false,false);
            lookupElems(root.right,ls,false,false);
            return;
        }
        
        // right boundary
        if (isRightBoundary) {
            lookupElems(root.left,ls,false,root.right==null);
            lookupElems(root.right,ls,false,root.right!=null);
            ls.add(root.val); //first call recursive function, then add val
            // so the val will be added to the list in reverse order
        }        
    }
}