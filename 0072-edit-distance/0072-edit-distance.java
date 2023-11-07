class Solution {
    Integer[][] dp;
    public int minDistance(String a, String b) {
        if (a == null || a.length() == 0) return b.length();
        if (b == null || b.length() == 0) return a.length();
        dp = new Integer[a.length()+1][b.length()+1];
        return helper(0,0,a,b);
    }
    
    private int helper(int i,int j,String a,String b){
        if (a.length() == i) {
            return b.length() - j;
        }
        if (b.length() == j) {
            return a.length() - i;
        }
        if(dp[i][j]!=null) return dp[i][j];
        int res;
        if(a.charAt(i) == b.charAt(j)){
            res = helper(i+1,j+1,a,b);
        }
        else{
            res = 1 + Math.min(helper(i+1,j+1,a,b) , Math.min(helper(i+1,j,a,b) ,
                                                             helper(i,j+1,a,b)));
        }
        dp[i][j] = res;
        return res;
    }
}