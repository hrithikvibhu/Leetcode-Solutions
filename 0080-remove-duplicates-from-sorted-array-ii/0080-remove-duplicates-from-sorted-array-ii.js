/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    let count = 0,k=0;
    for(let i=0;i<nums.length;i++){
        if(i>1 && nums[i]==nums[k-1] && nums[i] == nums[k-2]){
            continue;
        }
        nums[k++] = nums[i];
    }
    return k;
};