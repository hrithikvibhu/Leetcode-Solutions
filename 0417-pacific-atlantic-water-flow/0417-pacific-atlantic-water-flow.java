class Solution {
    List<List<Integer>> res;
        int n,m;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        res = new ArrayList<>();
        Set<String> a = new HashSet<>();
        Set<String> b = new  HashSet<>();
        n = heights.length;
        m = heights[0].length;
        for(int i=0;i<n;i++){
            dfs(i,0,a,heights[i][0],heights);
            dfs(i,m-1,b,heights[i][m-1],heights);
        }
        
        for(int i=0;i<m;i++){
            dfs(0,i,a,heights[0][i],heights);
            dfs(n-1,i,b,heights[n-1][i],heights);
        }
        for(int i=0;i<n;i++){
            for(int j =0 ; j<m;j++){
                String s = i+"-"+j;
                if(a.contains(s) && b.contains(s)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
        
    }
    
    
    private void dfs(int i,int j , Set<String> set , int prev,int[][] heights){
        String val = i+"-"+j;
        if(i<0||j<0||i>=n||j>=m||set.contains(val)||heights[i][j]<prev) return;
        
        set.add(val);
        dfs(i+1,j,set,heights[i][j],heights);
        dfs(i,j-1,set,heights[i][j],heights);
        dfs(i,j+1,set,heights[i][j],heights);
        dfs(i-1,j,set,heights[i][j],heights);
    }
    
}