class Solution {
    int[] parent;
    public int findCircleNum(int[][] a) {
        int n = a.length;
        parent = new int[n];
        int ans = n;
        for(int i=0;i<parent.length;i++)
            parent[i] = i;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] == 1){
                    int x = helper(i);
                    int y = helper(j);
                    if(x!=y){
                        parent[y] = x;
                        ans--;
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