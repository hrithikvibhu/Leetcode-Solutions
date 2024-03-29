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
    public int maxAncestorDiff(TreeNode root) {
        return helper(root,root.val,root.val);  
    }
    
    public int helper(TreeNode root , int min , int max){
        if(root == null)
            return max-min;
        min = Math.min(min,root.val);
        max = Math.max(max,root.val);
        return Math.max(helper(root.left,min,max),helper(root.right,min,max));
    }
}