class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        int n = days[days.length-1];
        int dp[] = new int[n+1];
        boolean visited[] = new boolean[n+1];
        dp[0] = 0;
        for(int d : days)
            visited[d] = true;
        for(int i=1;i<=n;i++){
            if(visited[i]==false){
                dp[i] = dp[i-1];
                continue;
            }
            
            dp[i] = cost[0] + dp[i-1];
            dp[i] = Math.min(dp[i] , cost[1]+dp[Math.max(0,i-7)]);
            dp[i] = Math.min(dp[i] , cost[2]+dp[Math.max(0,i-30)]);
        }
        return dp[n];
    }
}