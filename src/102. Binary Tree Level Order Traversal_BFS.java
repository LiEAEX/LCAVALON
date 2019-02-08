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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //edge case
        if (root == null) return new LinkedList<>();
        
        List<List<Integer>> res = new LinkedList<>();        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int len = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < len; i++){
                if (q.peek().left != null) q.add(q.peek().left);
                if (q.peek().right != null) q.add(q.peek().right);
                tmp.add(q.poll().val);
            } 
            res.add(tmp); 
        }
        return res;        
    }
}