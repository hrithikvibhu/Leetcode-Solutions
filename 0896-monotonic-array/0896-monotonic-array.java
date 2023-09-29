class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        int sign = nums[0]<=nums[n-1] ? 1 : -1;
        for(int i=0;i<n-1;i++){
            if(sign>0 && nums[i]>nums[i+1]){
                return false;
            }
            else if(sign <0 && nums[i]<nums[i+1])
                return false;
        }
        return true;
    }
}