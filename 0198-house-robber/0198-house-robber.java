class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
       int a = nums[0];
        int b = Math.max(a,nums[1]);
        int res = b;
        for(int i=2;i<nums.length;i++){
            res = Math.max(a+nums[i] , b);
            a = b;
            b = res;
        }
        return res;
    }
}