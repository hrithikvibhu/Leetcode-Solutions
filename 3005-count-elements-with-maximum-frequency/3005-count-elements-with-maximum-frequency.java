class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        for(int n : nums){
            count[n]++;
        }
        int max = -1;
        for(int i=0;i<101;i++){
            max = Math.max(max,count[i]);
        }
        int ans = 0;
        for(int i=0;i<101;i++){
            if(count[i] == max)
                ans += count[i];
        }
        return ans;
    }
}