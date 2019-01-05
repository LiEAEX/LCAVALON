/**
 * Breadth-first search 
 * BFS Approach
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // Inserts the specified element into this queue
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                // Retrieves and removes the head of this queue, or returns null if this queue is empty
                TreeNode node = queue.poll();
                size--;
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }
}