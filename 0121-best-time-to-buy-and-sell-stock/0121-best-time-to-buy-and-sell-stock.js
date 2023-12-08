/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let start = prices[0];
    let curr = 0;
    for(let i =1;i<prices.length;i++){
        if(0<prices[i]-start){
            curr = Math.max(curr , prices[i] - start);
        }
        else
            start = prices[i];
    }
    return curr;
};