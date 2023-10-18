class Solution {
    int res = 0;
    int n,m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    res = Math.max(res , dfs(i,j,grid) );
                }
            }
        }
   return res;
    }
    
    
    private int dfs(int i,int j , int[][] grid){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j] == 0)
            return 0;
        
        grid[i][j] = 0;
        int area = 1 + dfs(i+1,j,grid) + dfs(i-1,j,grid)+dfs(i,j+1,grid)+dfs(i,j-1,grid);
        return area;
    }
    
}