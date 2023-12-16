/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function(gas, cost) {
    const n = gas.length;
    let sum = 0;
    for(let i =0;i<n;i++){
        gas[i] -= cost[i];
        sum += gas[i];
    }
    let res = 0;
    if(sum<0) return -1;
    let total = 0;
    for(let i=0;i<n;i++){
        total += gas[i];
        if(total<0){
            res = i+1;
            total = 0;
        }
    }
    return res;
};