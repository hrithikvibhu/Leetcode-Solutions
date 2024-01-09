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
    List<Integer> l1,l2;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        l1 = new ArrayList<>();
        l2 = new ArrayList<>();
       inorder(root1,l1);
        inorder(root2,l2);
        return l1.equals(l2);
    }
    
    private void inorder(TreeNode root,List<Integer> list){
        if(root ==null) return;
        if(root.left == null && root.right==null) {
            list.add(root.val);
        }
        inorder(root.left,list);
        inorder(root.right,list);
    }
}