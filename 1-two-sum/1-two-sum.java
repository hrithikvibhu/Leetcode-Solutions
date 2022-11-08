class Solution {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                result[0]=i;
                result[1] = map.get(target-arr[i]);
                return result;
            }
            map.put(arr[i],i);
        }
        return result;
    }
    
    
    
    
}