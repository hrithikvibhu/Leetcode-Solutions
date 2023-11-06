class Solution {
    Integer[][] dp ;
    public int longestCommonSubsequence(String a, String b) {
        dp = new Integer[a.length()][b.length()];
        return helper(0,0,a,b);
    }
    
    private int helper(int i,int j , String a , String b){
        if(i>=a.length() || j>=b.length()) return 0;
        if(dp[i][j] !=null) return dp[i][j];
        int res;
        if(a.charAt(i) == b.charAt(j)){
            res = 1 + helper(i+1,j+1,a,b);
        }
        else{
            res =  Math.max(helper(i+1,j,a,b) , helper(i,j+1,a,b));
        }
        dp[i][j] = res;
        return res;
    }
}