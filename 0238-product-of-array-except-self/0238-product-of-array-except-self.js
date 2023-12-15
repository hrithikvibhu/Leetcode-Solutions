/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    const n = nums.length;
    let prefix = new Array(n).fill(1);
    for(let i=1;i<n;i++){
        prefix[i] = (nums[i-1]*prefix[i-1]);
    }
    let suffix = new Array(n).fill(1);
    
    for(let i=n-2;i>=0;i--){
        suffix[i] = (nums[i+1]) * suffix[i+1];
    }
    
    for(let i=0;i<n;i++){
        prefix[i] *= suffix[i];
    }
    return prefix;
};