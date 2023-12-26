class Solution {
    public int minOperations(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                if(s.charAt(i)!='0')
                    ans += 1;
                else 
                    ans += 0;
            }
            else{
                if(s.charAt(i)!='1')
                    ans += 1;
                else 
                    ans += 0;
            }
        }
        return Math.min(ans , s.length()-ans);
    }
}