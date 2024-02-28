/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode node;
            while(size-- > 0 ){
                node = q.poll();
                res = node.val;
                if(node.right!=null)
                    q.offer(node.right);
                if(node.left!=null)
                    q.offer(node.left);
            }
            
        }
        return res;
    }
}