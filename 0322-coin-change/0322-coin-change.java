class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new Integer[n+1][amount+1];
        int res =  helper(0,coins,amount);
        return res == Integer.MAX_VALUE - 1 ? -1 : res;
    }
    
    private int helper( int i , int[] coins , int target ){
        if(dp[i][target] !=null ) return dp[i][target];
        
        if(i>=coins.length || target<0) return Integer.MAX_VALUE-1;
        
        if(target == 0) return 0;
        
        if(coins[i]>target) { dp[i][target]  = helper(i+1,coins,target); }
        else{
            dp[i][target] = Math.min(helper(i+1,coins,target) , 1+ helper(i,coins,target-coins[i]));
        }
        return dp[i][target];
    }
    
    
}