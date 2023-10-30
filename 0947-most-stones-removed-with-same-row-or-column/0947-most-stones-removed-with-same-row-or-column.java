class Solution {
    int[] parent;
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[][] matrix = new int[n][n];
        
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;
                }
            }
        }
        
        parent = new int[n];
        
        for(int i=0;i<n;i++) parent[i] = i;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 1){
                    int x = helper(i);
                    int y = helper(j);
                    if(x!=y){
                        ans++;
                        parent[y] = x;
                    }
                }
            }
        }
        
        return ans;
    }
    
    private int helper(int x){
        return parent[x] == x ? x : helper(parent[x]);
    }
}