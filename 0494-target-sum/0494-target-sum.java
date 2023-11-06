class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0,nums,target);
    }
    
    private int helper(int i , int[] nums ,int  t){
        if(i==nums.length){
            if(t==0) return 1;
            return 0;
        }
        String key = i+"-"+t;
        if(map.containsKey(key))
            return map.get(key);
        
        int res = helper(i+1,nums,t-nums[i]) + helper(i+1,nums,t+nums[i]);
        map.put(key,res);
        return res;
    }
}