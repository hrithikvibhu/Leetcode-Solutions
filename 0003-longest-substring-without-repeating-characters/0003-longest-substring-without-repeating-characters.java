class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0 , end = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while(end<n){
            if( !set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                res = Math.max(res,end-start+1);
                end++;
            }
            else{
                set.remove(s.charAt(start++));
            }
        }
        return res;
    }
    
}