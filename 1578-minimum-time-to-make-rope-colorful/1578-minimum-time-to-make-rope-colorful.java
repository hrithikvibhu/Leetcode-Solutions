class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int l=0,r=0 , ans = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int currSum = 0;
        while(r<n){
            if(colors.charAt(r)!=colors.charAt(l)){
                int len = r-l;
                if(len>1)
                    ans += (currSum - maxSoFar);
                l = r;
                maxSoFar = neededTime[r];
                currSum = neededTime[r];
                    
            }
            else{
                maxSoFar = Math.max(maxSoFar , neededTime[r]);
                currSum += neededTime[r];
            }
            r++;
        }
        int len = r-l;
        if(len>1)
            ans += currSum - maxSoFar;
        return ans;
    }
}