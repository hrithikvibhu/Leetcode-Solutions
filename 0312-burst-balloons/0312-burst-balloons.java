class Solution {
    Integer[][] dp ;
    int[] arr;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new Integer[n+3][n+3];
        arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        int i=1;
        for(int j:nums)
            arr[i++] = j;
        return dfs(1,arr.length-2);
    }
    
    private int dfs(int l,int r){
        if(l>r) 
            return 0;
        if(dp[l][r]!=null)
            return dp[l][r];
        int max =-1;
        for(int i=l;i<=r;i++){
            int res = arr[l-1] * arr[i] * arr[r+1];
            res += dfs(l,i-1) + dfs(i+1,r);
            max = Math.max(max,res);
        }
        dp[l][r] = max;
        return dp[l][r];
    }
}