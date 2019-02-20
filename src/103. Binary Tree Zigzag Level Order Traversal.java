/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

Runtime: 1 ms, faster than 89.59% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
Memory Usage: 37.1 MB, less than 46.18% of Java online submissions for Binary Tree Zigzag Level Order Traversal.

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> arr = new LinkedList<>(); // must use LinkedList reference type, or the addFirst method will not work
        Queue<TreeNode> q = new LinkedList();
        if (root == null) return res;
        
        q.offer(root);
        boolean order = false;
        while (q.size() != 0){
            int len = q.size();
            order = !order;
            arr = new LinkedList<>();
            for (int i = 0; i < len; i++){
                TreeNode tp = q.poll();
                if (order){
                    arr.add(tp.val);
                } else {
                    arr.addFirst(tp.val);
                }
                if (tp.left != null){
                    q.offer(tp.left);
                }
                if (tp.right != null){
                    q.offer(tp.right);
                }
            }
            res.add(arr);
        }
        return res;
    }
}


DFS approach:

public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList();
    travel(res, 0, root);
    return res;
}
private void travel(List<List<Integer>> res, int level, TreeNode cur) {
    if (cur == null) return;
    if (res.size() <= level) {
        res.add(new ArrayList<Integer>());
    }
    if (level % 2 == 0) {
        res.get(level).add(cur.val);
    } else {
        res.get(level).add(0, cur.val); // insert the cur.val to the head of the list(the index of head is 0)
    }
    travel(res, level + 1, cur.left);
    travel(res, level + 1, cur.right);
}