class Solution {
    public int maxSubArray(int[] nums) {
       int res = Integer.MIN_VALUE;
        int curr = 0;
        for(int n : nums){
            curr = Math.max(curr+n,n);
            res = Math.max(res , curr);
        }
        return res;
    }
}