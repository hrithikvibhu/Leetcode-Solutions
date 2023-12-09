/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    k = k % nums.length;
    helper(nums,0,nums.length-1);
    helper(nums,0,k-1);
    helper(nums,k,nums.length-1);
    return nums;
};

function helper(nums,start,end){
    while(start<end){
        let temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}