class Solution {
    int n,m;
    Integer[][]dp;
    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();
        if(n<m) return 0;
        dp = new Integer[n+1][m+1];
        return helper(0,0,s,t);
    }
    
    private int helper(int i,int j ,String s,String t){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        
        if(dp[i][j]!=null) return dp[i][j];
        int max = helper(i+1,j,s,t);
        
        if(s.charAt(i) == t.charAt(j))
            max += helper(i+1,j+1,s,t);
        dp[i][j] = max;
        return max;
    }
}