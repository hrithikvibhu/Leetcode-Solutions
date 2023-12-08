/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    strs = strs.sort();
    let i = 0;
    while(i<strs[0].length && i<strs[strs.length-1].length){
        if(strs[0].charAt(i)!= strs[strs.length-1].charAt(i))
            break;
        else
            i++;
    }
    return strs[0].substring(0,i);
};