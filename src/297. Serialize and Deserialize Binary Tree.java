/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Preorder-Traversal, Recursive
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        serializeHelper(root, res);
        return res.toString();
    }
    
    private void serializeHelper(TreeNode root, ArrayList<Integer> res){
        if (root == null) {
            res.add(null);
            return;
        }
        res.add(root.val);
        serializeHelper(root.left, res);
        serializeHelper(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.substring(1, data.length() - 1).split(", "); // remove "[" and "]" and split string into string array
        LinkedList<String> strList = new LinkedList<>(Arrays.asList(str)); 
        return deserializeHelper(strList);
    }
    private TreeNode deserializeHelper(LinkedList<String> strList){
        if (strList.size() == 0) return null;
        String str = strList.pop();
        if (str.equals("null")) return null;
        TreeNode currentRoot = new TreeNode(Integer.parseInt(str));
        currentRoot.left = deserializeHelper(strList);
        currentRoot.right = deserializeHelper(strList);
        return currentRoot;
    } 
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));