Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
Memory Usage: 36.2 MB, less than 27.80% of Java online submissions for Binary Tree Inorder Traversal.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
中序遍历(Inorder Traversal)

recurison 递归
class Solution {   
    List<Integer> res = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null){
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
        }
        return res;
    }
}

iteration 迭代（非递归）
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        while(true){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            if (st.isEmpty()) break;
            root = st.pop();
            res.add(root.val);
            root= root.right;
        }
        return res;
    }
}