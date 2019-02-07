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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>(); //edge case
        
        Queue<TreeNode> myq = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root==null) return null;
        myq.add(root);
        while(!myq.isEmpty()){
            int len = myq.size();
            List<Integer> tmp = new ArrayList<>();;
            for(int i = 0; i < len; i++){
                if(myq.peek().left != null) myq.add(myq.peek().left);
                if(myq.peek().right != null) myq.add(myq.peek().right);
                tmp.add(myq.poll().val);                 
            }
            res.add(tmp.get(tmp.size() - 1));
        }
        return res;
    }
}