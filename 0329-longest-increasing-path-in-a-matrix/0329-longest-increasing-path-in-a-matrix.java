class Solution {
    Integer[][] dp;
    int n,m;
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        dp = new Integer[n+1][m+1];
        int res = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res = Math.max(res , helper(i,j,matrix,Integer.MIN_VALUE));
            }
        }
        return res;
    }
    
    private int helper(int i,int j,int[][] matrix,int pre){
        if(i<0||j<0||i>=n||j>=m || pre>=matrix[i][j]) return 0;
        
        if(dp[i][j] !=null){
            return dp[i][j];
        }
        
        int res ;
        res = Math.max(helper(i+1,j,matrix,matrix[i][j]),
                      helper(i-1,j,matrix,matrix[i][j]));
        res = Math.max( res , Math.max(helper(i,j+1,matrix,matrix[i][j]) ,
                                      helper(i,j-1,matrix,matrix[i][j])));
        dp[i][j] = res + 1;
        return dp[i][j];
    }
}