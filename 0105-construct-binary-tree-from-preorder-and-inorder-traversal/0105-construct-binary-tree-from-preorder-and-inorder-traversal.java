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
    int index = 0;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        TreeNode root = helper(preorder,0,inorder.length-1);
        return root;
    }
    
    private TreeNode helper(int[]preorder,int l , int r){
        if(l>r)
            return null;
        TreeNode root = new TreeNode(preorder[index++]);
        int inorder = map.get(root.val);
        root.left = helper(preorder,l,inorder-1);
        root.right = helper(preorder,inorder+1,r);
        return root;
    }
}