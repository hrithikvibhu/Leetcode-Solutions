class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length-1;
        int res = 0;
        while(i!=0){
            int largest = nums[i];
            int nextLargest = nums[i-1];
            if(largest == nextLargest){
                i--;
                continue;
            }
            else{
                res += nums.length-i;
                i--;
            }
        }
        return res;
    }
}