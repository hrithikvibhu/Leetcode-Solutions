class Solution {
    int n;
    Integer[] dp; 
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = profit.length;
        dp = new Integer[n+2];
        int[][] intervals = new int[n][3];
        for(int i=0;i<n;i++){
            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
            intervals[i][2] = profit[i];
        }
        
        Arrays.sort(intervals , (a,b)->a[0]-b[0]);
        return helper(0,intervals);
    }
    
    public int helper(int index  , int[][] intervals){
        if(index>=n) return 0;
        
        // include or not include
        if(dp[index]!=null)
            return dp[index];
        int j = findNext(index,intervals) ;
        
        int include = (j == -1 ? 0 : helper(j , intervals) )+ intervals[index][2];
        
        int exclude = helper(index+1,intervals) + 0;
        
        int res = Math.max(include , exclude);
        dp[index] = res;
        return res;
    }
    
     int findNext(int cur, int[][] jobs) {
        for (int next = cur + 1; next < jobs.length; next++) {
            if (jobs[next][0] >= jobs[cur][1]) {
                return next;   
            }
        }
        return -1;
    }
}