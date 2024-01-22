class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] map = new int[10005];
        int limit = -1;
        for(int num:nums){
            map[num]++;
            limit = Math.max(limit,n);
        }
        int[] res = new int[2];
        for(int i=1;i<limit+1;i++){
            if(map[i]==0)
                res[1] = i;
            if(map[i] == 2)
                res[0] = i;
        }
        return res;
    }
}