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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int res = 0;
        Map<TreeNode, Integer> m = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        m.put(root, 1);
        int start = 0, end = 0;
        while(!q.isEmpty()){
            int len = q.size();
            start = 0;
            end = 0;
            for (int i = 0; i < len; i++){
                root = q.poll();
                if (i == 0) start = m.get(root);
                if (i == len - 1) end = m.get(root);
                
                if (root.left != null){
                    q.offer(root.left);
                    m.put(root.left, 2*m.get(root));
                }
                if (root.right != null){
                    q.offer(root.right);
                    m.put(root.right, 2*m.get(root)+1);
                }
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}


class Solution {
    Map<Integer, int[]> map = new HashMap<>();
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        findMax(root, 0, 0);
        
        int res = 1;
        for (int[] rec : map.values()) {
            res = Math.max(res, rec[1] - rec[0] + 1);
        }
        
        return res;
    }
    
    private void findMax(TreeNode root, int level, int pos) {
        if (root == null) return;
        
        int[] rec = map.get(level);
        if (rec == null) {
            rec = new int[2];
            rec[0] = Integer.MAX_VALUE;
            rec[1] = Integer.MIN_VALUE;
        }

        rec[0] = Math.min(rec[0], pos);
        rec[1] = Math.max(rec[1], pos);
        map.put(level, rec);
        
        findMax(root.left, level + 1, 2 * pos);
        findMax(root.right, level + 1, 2 * pos + 1);
    }
}