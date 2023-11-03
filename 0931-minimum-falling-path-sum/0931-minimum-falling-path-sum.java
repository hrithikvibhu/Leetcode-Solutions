class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    matrix[i][j] += Math.min(matrix[i-1][j] , matrix[i-1][j+1]);
                }
                else if(j==n-1){
                    matrix[i][j] += Math.min(matrix[i-1][j] , matrix[i-1][j-1]);
                }
                else{
                   matrix[i][j] += Math.min(matrix[i-1][j+1] ,  Math.min(matrix[i-1][j] , matrix[i-1][j-1])); 
                }
            }
        }
        for(int i=0;i<n;i++)
            res = Math.min(res, matrix[n-1][i]);
        
        return res;
    }
}