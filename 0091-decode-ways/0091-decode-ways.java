class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            Integer first = Integer.valueOf(s.substring(i,i+1));
            if(first>=1 && first<=9)
                dp[i] = i==0 ? 1+dp[i] : dp[i-1] + dp[i];
            
            if(i>0){
                Integer second = Integer.valueOf(s.substring(i-1,i+1));
                if(second>=10 && second<=26)
                    dp[i] = i==1 ? 1+dp[i] : dp[i]+dp[i-2];
            }
        }
        return dp[n-1];
    }
}