/**
 * @param {number[]} citations
 * @return {number}
 */
var hIndex = function(citations) {
   citations.sort(function(a, b) {
  return a - b; // Ascending order
});
    const n = citations.length;
    for(let i=0;i<n;i++){
        if(citations[i] >= (n-i))
           return (n-i);
    }
    return 0;
};