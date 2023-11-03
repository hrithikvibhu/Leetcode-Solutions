class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int n =  s.length();
        boolean[][] dp = new boolean[n][n]; 
        int maxLen=0; 
        int start=0;
        int end =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if( s.charAt(i)==s.charAt(j) && ( i-j<3 ||  dp[j+1][i-1])){
                    dp[j][i] = true;
                }
                if(maxLen<i-j+1 && dp[j][i]){
                    start = j;
                    end = i;
                    maxLen = i-j+1;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}