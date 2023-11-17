class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , (x,y) -> x[0] - y[0]);
        int res = 0;
        if (intervals.length == 0) {
			return res;
		}
        int start = intervals[0][0] , end = intervals[0][1];
        for(int i=1;i< intervals.length;i++){
            if(end > intervals[i][0]){
                res++;
                end = Math.min(end,intervals[i][1]);
            }
            else
                end = intervals[i][1];
        }
        return res;
    }
}