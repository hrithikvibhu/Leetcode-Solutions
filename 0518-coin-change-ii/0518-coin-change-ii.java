class Solution {
    int res = 0;
    Integer dp[][];
    public int change(int amount, int[] coins) {
        dp = new Integer[amount+1][coins.length+1];
        Arrays.sort(coins);
        return helper(0,amount,coins);
    }
    
    private int helper(int i,int target ,int[] coins){
        if(target<0 || i>=coins.length) return 0;
        if(target == 0) return 1;
        if(dp[target][i] !=null) return dp[target][i];
        if(coins[i]<=target){
            dp[target][i] =  helper(i,target-coins[i],coins)+helper(i+1,target,coins);
        }
        else
            dp[target][i] = helper(i+1,target,coins);
        return dp[target][i];
    }
}