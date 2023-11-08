class Solution {
    Boolean[][] dp;
    int n,m;
    public boolean isMatch(String s, String p) {
        n = s.length();
        m = p.length();
        dp = new Boolean[n+1][m+1];
        return helper(0,0,s,p);
    }
    
    private boolean helper(int i,int j , String s, String p){
        if(i>=s.length() && j>=p.length())
            return true;
        if(j>=p.length())
            return false;
        
        if(dp[i][j]!=null) return dp[i][j];
        
        boolean match =false;
        
        if(i<n && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'))
            match = true;
        
        if(j<m-1 && p.charAt(j+1)=='*'){
            dp[i][j] = helper(i,j+2,s,p) || (match && helper(i+1,j,s,p));
            return dp[i][j];
        }
        
        if(match){
            dp[i][j] = helper(i+1,j+1,s,p);
            return dp[i][j];
        }
        dp[i][j]=false;
        return false;
        
    }
}