class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int ans = 0;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } }; 
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] polled = q.poll();
                for(int[] d : directions){
                    int x = polled[0] + d[0];
                    int y = polled[1] + d[1];
                    if(x<0 || y<0 || x>=n || y>=m || grid[x][y]!= 1) continue;
                    grid[x][y] = 2;
                    q.offer(new int[]{x,y}); 
                }
            }
            if(q.size()>0)
                ans++;
        }
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]==1)
                    return -1;
        
        return ans;
    }
}