class Solution {
    public int minOperations(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(i%2==0)
                ans += s.charAt(i)!='0' ? 1 : 0;
            else
                ans += s.charAt(i)!='1' ? 1 : 0;       
        }
        return Math.min(ans , s.length()-ans);
    }
}