class Solution {
    Map<String,Boolean> map = new HashMap<>();
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if( sum %2 !=0) return false;
        
        return helper(0,nums,sum/2);
    }
    
    private boolean helper(int i,int[] nums , int sum){
        String key = i+"-"+sum;
        if(map.containsKey(key))
            return map.get(key);
        if(i>=nums.length || sum<0) return false;
        if(sum ==0) return true;
        boolean res = helper(i+1,nums,sum-nums[i]) || helper(i+1,nums,sum);
        map.put(key,res);
        return res;
    }
}