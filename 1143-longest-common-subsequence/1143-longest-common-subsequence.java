class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new Integer[text1.length()+1][text2.length()+1];
        return helper(0,0,text1,text2);
    }
    
    private int helper(int i, int j , String a , String b){
        
        if(i>=a.length() || j>=b.length())
            return 0;
        
        int res = 0;
        if(dp[i][j]!=null)
            return dp[i][j];
        if(a.charAt(i) == b.charAt(j)){
            res = helper(i+1,j+1,a,b)+1;   
        }
        else{
            res  = Math.max(helper(i+1,j,a,b) , helper(i,j+1,a,b));
        }
        dp[i][j] = res;
        return res;
    }
}