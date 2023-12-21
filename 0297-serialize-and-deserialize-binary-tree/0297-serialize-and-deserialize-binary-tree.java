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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        builder(sb,root);
        return sb.toString();
    }
    
    public void builder(StringBuilder sb,TreeNode root){
        if(root == null){
            sb.append("X").append(",");
        }else{
            sb.append(root.val).append(",");
            builder(sb,root.left);
            builder(sb,root.right);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return resolver(q);
    }
    
    public TreeNode resolver(Queue<String> q){
        String pop = q.remove();
        if(pop.equals("X")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(pop));
        root.left = resolver(q);
        root.right = resolver(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));