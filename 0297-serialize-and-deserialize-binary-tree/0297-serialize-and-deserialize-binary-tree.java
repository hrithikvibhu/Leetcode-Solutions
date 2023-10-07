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
        helper1(root,sb);
                System.out.println(sb.toString());

        return sb.toString();
    }
    
    public void helper1(TreeNode root,StringBuilder sb){
        if(root == null)
            sb.append("X").append(",");
        else{
            sb.append(root.val).append(",");
            helper1(root.left,sb);
            helper1(root.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        // System.out.println(data);

        q.addAll(Arrays.asList(data.split(",")));
        return helper2(q);
    }
    
    public TreeNode helper2(Queue<String> q){
        String val = q.remove();
        System.out.println(val);
        if(val.equals("X"))
            return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = helper2(q);
            node.right = helper2(q);
            return node;}
    } 
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));