class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r = n-1;
        for(int i = 0;i<n;i++){
            if(nums[i]%2==0){
                res[l++] = nums[i];
            }
            else{
                res[r--] = nums[i];
            }
        }
        return res;
    }
}