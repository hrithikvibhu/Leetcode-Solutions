class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        list = new ArrayList<>();
        helper(0,target,cand , new ArrayList<>());
        return list;
    }
    
    private void helper(int index , int target , int[] cand , List<Integer> subList){
        if(target == 0){
            list.add(new ArrayList<>(subList));
            return;
        }
        if(target<0) return;
        
        for(int i=index;i<cand.length;i++){
            subList.add(cand[i]);
            helper(i,target-cand[i],cand,subList);
            subList.remove(subList.size()-1);
        }
    }
}