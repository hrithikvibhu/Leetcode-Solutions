class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
    
        parent = new int[edges.length+1];
        for(int i=0;i<edges.length;i++)
            parent[i] = i;
        
        for(int[] e : edges){
            int x = helper(e[0]);
            int y = helper(e[1]);
            if(x!=y)
                parent[y] = x;
            else{
                res[0] = e[0];
                res[1] = e[1];
            }
        }
        return res;
        
    }
    
    private int helper(int x){
        return parent[x] == x ? x : helper(parent[x]);
    }
}