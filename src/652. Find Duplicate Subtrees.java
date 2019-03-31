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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        if (root == null) return res;
        
        HashMap<String, TreeNode> m = new HashMap<>();
        findHelper(root, m);
        for (TreeNode tre : m.values()){
            if (tre != null) res.add(tre);
        }
        return res;
    }
    
    private String findHelper(TreeNode root, HashMap<String, TreeNode> m){
        // leaf nodes
        if (root.left == null && root.right == null){
            String temp = "" + root.val;
            if(!m.containsKey(temp)){
                m.put(temp, null);
            }
            else m.put(temp, root);
            return temp;
        }
        // preorder: left->right->root
        String left = "", right = "";
        if (root.left != null){
            left = findHelper(root.left, m);
        }
        if (root.right != null){
            right = findHelper(root.right, m);
        }        
        String str = left + "," + right + "," + root.val;
        
        if(!m.containsKey(str)){
            m.put(str, null);
        }
        else m.put(str, root);
        
        return str;        
    }
}