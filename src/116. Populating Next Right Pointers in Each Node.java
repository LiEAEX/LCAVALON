/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) return null;
        
        Node res = root;
        q.offer(root);
        root.next = null;
        Node temp = null;
        while(!q.isEmpty()){
            int len = q.size();
            temp = null;
            for (int i = 0; i < len; i++){
                root = q.poll();
                if(root.left != null && root.right != null){
                    if (temp != null) temp.next = root.left;
                    q.offer(root.left);
                    q.offer(root.right);
                    root.left.next = root.right;
                    temp = root.right;
                }
            }
        }
        
        return res;
    }
}