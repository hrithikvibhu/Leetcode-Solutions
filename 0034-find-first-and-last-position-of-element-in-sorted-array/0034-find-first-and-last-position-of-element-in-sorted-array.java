class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        return new int[]{helper(0,nums.length-1,nums , target),
                        helper2(0,nums.length-1,nums,target)};
        
    }
    
    public int helper(int l , int r , int[] nums , int target){
        int res = -1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(nums[m]>= target){
                r = m-1;
            }
            else 
                l = m+1;
            if(nums[m] == target)
            res = m;
        }
        
        return res;
    }
    
    public int helper2(int l , int r , int[] nums , int target){
        int res = -1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(nums[m]> target){
                r = m-1;
            }
            else 
                l = m+1;
            
            if(nums[m] == target)
            res = m;
        }
        
        return res;
    }
}