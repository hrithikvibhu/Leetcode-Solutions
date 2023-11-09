class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int n = gas.length;
        for(int i =0;i<n;i++){
            gas[i] -= cost[i];
            sum += gas[i];
        }
        
        if(sum<0) return -1;
        int total = 0,res = 0;
        for(int i = 0;i<n;i++){
            total += gas[i];
            if(total<0){
                total = 0;
                res = i+1;
            }
        }
        return res;
    }
}