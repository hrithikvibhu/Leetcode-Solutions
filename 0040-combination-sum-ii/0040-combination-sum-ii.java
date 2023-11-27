class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
      res = new ArrayList<>();
        helper(nums,0,new ArrayList<>() , target);
        return res;
    }
    
    private void helper(int[] nums , int index , List<Integer> list , int t){
        if(t==0){
            res.add( new ArrayList<>(list));
            return;
        }
        if(t<0) return;
        
        for(int i=index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]) continue; // skip duplicates
            list.add(nums[i]);
            helper(nums,i+1,list,t-nums[i]);
            list.remove(list.size()-1);
            // while(i<nums.length-1 && nums[i]==nums[i+1]) i++;
        }
    }
}