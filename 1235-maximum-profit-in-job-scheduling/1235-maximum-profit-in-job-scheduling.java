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
    
     int findNext(int idx, int[][] jobs) {
        int lo = idx + 1;
        int hi = jobs.length -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(jobs[mid][0] >= jobs[idx][1]) {
                if(jobs[mid-1][0] >= jobs[idx][1])
                    hi = mid - 1;
                else 
                    return mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return -1;
    }
}