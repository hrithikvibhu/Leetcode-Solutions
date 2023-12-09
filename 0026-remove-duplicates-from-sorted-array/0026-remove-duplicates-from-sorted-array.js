/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    let k =0;
    for(let i=0;i<nums.length;i++){
        if(i>0 &&  nums[i] == nums[k-1]) continue;
        nums[k++] = nums[i];
    }
    return k;
};