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
    int count = 0;
    public int goodNodes(TreeNode root) {
        helper(root,root.val);
        return count;
    }
    
    public void helper(TreeNode root,int currMax){
        if(root == null)
            return;
        if(currMax<=root.val)
            count++;
        helper(root.left,Math.max(currMax,root.val));
        helper(root.right,Math.max(currMax,root.val));
    }
}