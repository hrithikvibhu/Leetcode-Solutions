class Solution {
    int[] parent;
    public int makeConnected(int n, int[][] connections) {
        int size = connections.length;
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
        if(size<n-1) return -1;
        for(int i=0;i<size;i++){
            
               
                    int x = helper(connections[i][0]);
                    int y = helper(connections[i][1]);
                    if(x!=y)
                        parent[y] = x;
                
            
        }
        int ans = 0;
        for(int i=0;i<n;i++)
            if(parent[i] == i)
                ans++;
        return ans-1;
    }
    private int helper(int x){
        return parent[x] == x ? x : helper(parent[x]);
    }
}