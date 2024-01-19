class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        
        int[][] dirs = { {-1,-1} , {-1,0} , {-1,1}};
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>0){
                    int min = Integer.MAX_VALUE;
                    for(int[] dir : dirs){
                        int new_x = i + dir[0];
                        int new_y =  j+ dir[1];
                        if(isValid(new_x,new_y,n)){
                            min = Math.min(min , matrix[i][j] + dp[new_x][new_y]);
                        }
                        dp[i][j] = min;
                    }
                }
                else
                    dp[i][j] = matrix[i][j];
            }
        }
        
        for(int j=0;j<n;j++)
            res  = Math.min(res , dp[n-1][j]);
        
        return res;
    }
    
    private boolean isValid(int i,int j , int n){
        if(i>=n || j>=n || i<0 || j<0)
            return false;
        return true;
    }
}