class Solution {
    public int countNicePairs(int[] nums) {
        int res = 0, mod = (int)1e9 + 7;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            int x = rev(n);
            int count = map.getOrDefault(n-x,0);
            map.put(n-x,count+1);
            res = (res+count)%mod;
        }
        return res;
    }
    
    private int rev(int x){
        int res = 0;
        while(x>0){
            res = (x%10) + res*10 ;
            x = x/10;
        }
        return res;
    }
}