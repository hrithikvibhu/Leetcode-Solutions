class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(0,0,text1,text2);
    }
    
    private int helper(int i,int j , String a , String b){
        if(i>=a.length() || j>=b.length()) return 0;
        String key = i+"-"+j;
        if(map.containsKey(key))
            return map.get(key);
        int res;
        if(a.charAt(i) == b.charAt(j)){
            res = 1 + helper(i+1,j+1,a,b);
        }
        else{
            res =  Math.max(helper(i+1,j,a,b) , helper(i,j+1,a,b));
        }
        map.put(key,res);
        return res;
    }
}