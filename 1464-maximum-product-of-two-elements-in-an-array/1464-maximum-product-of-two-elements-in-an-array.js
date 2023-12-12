/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    let num = nums.sort(function(a,b){
        return b-a;
    });
    const n = num.length;
    const a = (num[0]) - 1;
    const b = (num[1]) - 1;
    return a*b;
};