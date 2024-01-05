class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int res =0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0){
                int[] pop = q.poll();
                for(int[] dir : dirs){
                    int x = pop[0]+dir[0];
                    int y = pop[1]+dir[1];
                    if(x<0 || y<0 ||x>=n || y>=m || grid[x][y]==0 || grid[x][y]==2)
                        continue;
                
                    if(grid[x][y] == 1){
                        grid[x][y] = 2;
                        q.offer(new int[]{x,y});
                    }
                }
                size--;
            }
            if(q.size()>0) res++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                if(grid[i][j]==1) return -1;
        }
        return res;
    }
}