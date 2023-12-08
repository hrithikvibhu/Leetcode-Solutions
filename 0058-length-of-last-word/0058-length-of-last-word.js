/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    s = s.trim();
    let tokens = s.split(" ");
    return tokens.length >0 ? tokens[tokens.length-1].length : s.length;
};