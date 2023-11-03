class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            String first = s.substring(i-1,i);
            String second = s.substring(i-2,i);
            
            Integer j = Integer.valueOf(first);
            if(j>=1 && j<=9)
                dp[i] += dp[i-1];
            j = Integer.valueOf(second);
            if(j<=26 && j>=10)
                dp[i] +=dp[i-2];
        }
        return dp[n];
    }
}