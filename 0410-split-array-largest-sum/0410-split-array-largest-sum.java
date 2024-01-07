class Solution {
    public int splitArray(int[] nums, int k) {
        int l = Integer.MIN_VALUE,r=0;
        for(int n:nums){
            l = Math.max(l,n);
            r += n;
        }
        int res =r;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(helper(nums,k,mid)){
                r = mid-1;
                res = mid;
            }
            else{
                l = mid+1;
            }
        }
        return res;
    }
    
    
    public boolean helper(int[] nums , int k , int mid){
        int p = 1;
        int i=0,currSum=0;
        while(i<nums.length){
            currSum +=nums[i];
            if(currSum>mid){
                p++;
                currSum = nums[i]; 
            }
            i++;
        }
        return p<=k ? true : false;
    }
}