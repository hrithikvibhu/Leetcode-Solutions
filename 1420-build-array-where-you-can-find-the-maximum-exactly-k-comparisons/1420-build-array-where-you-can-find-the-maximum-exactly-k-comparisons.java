class Solution {
    int n,m,k;
    Integer dp[][][];
    public int numOfArrays(int N, int M, int K) {
        dp = new Integer[51][101][51];
        n = N ; m = M ; k = K;
        return helper(0,0,0);
    }
    
    public int helper(int currMax , int lis , int index){
        if(index == n){
            if(lis == k)
                return 1;
            
            return 0;
        }
        if(dp[index][currMax][lis]!=null)
            return dp[index][currMax][lis];
        int ans = 0;
        for(int i=1;i<=m;i++){
            if(i<=currMax)
                ans+= helper(currMax,lis,index+1);
            else
                ans += helper(i,lis+1,index+1);
            
            ans = ans %1000000007;
        }
        dp[index][currMax][lis] = ans;
        return ans;
    }
}