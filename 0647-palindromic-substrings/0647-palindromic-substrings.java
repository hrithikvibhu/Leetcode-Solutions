class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n==1) return 1;
        
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i) == s.charAt(j) && (i-j<3 || dp[j+1][i-1]) ){
                    dp[j][i] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}