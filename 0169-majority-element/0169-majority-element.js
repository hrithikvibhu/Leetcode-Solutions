/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    let count = 1,res = nums[0];
    for(let i =1;i<nums.length;i++){
        if(count == 0){
            count = 1;
            res = nums[i];
        }
        else if(res == nums[i]){
             count++;
        }
        else
            count--;
    }
    return res;
};