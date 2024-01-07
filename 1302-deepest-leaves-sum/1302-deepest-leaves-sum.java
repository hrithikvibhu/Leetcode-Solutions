class Solution {
    int maxDepth = 0 ;
    int maxSum = 0;
    public int deepestLeavesSum(TreeNode root) {
        maxDepth = helper(root);
        System.out.println(maxDepth);
        helper2(root,1);
        return maxSum;
    }
    
    public int helper(TreeNode root){
        if(root==null)
            return 0 ;
        
        int l = 1 + helper(root.left);
        int r = 1 + helper(root.right);
        return Math.max(l,r);
    }
    
    public void helper2(TreeNode root,int currLevel){
        if(root==null)
            return;
        if(currLevel == maxDepth)
            maxSum += root.val;
        helper2(root.left,currLevel+1);
        helper2(root.right,currLevel+1);
    }
}