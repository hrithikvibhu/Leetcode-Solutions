class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int start=0,end=0,res=0;
        Map<Character,Integer> map = new HashMap<>();
        int maxx = 0;
        while(end<n){
            map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)+1);
            maxx = Math.max(maxx,map.get(s.charAt(end)));
            if(end-start+1-maxx>k){
                map.put(s.charAt(start),map.getOrDefault(s.charAt(start),0)-1);
                start++;
            }
            res = Math.max(res,end-start+1);
            end++;
        }
        return res;
    }
}