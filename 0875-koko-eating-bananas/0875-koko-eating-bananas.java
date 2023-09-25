class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i:piles)
            max = Math.max(max,i);
        
        int l=1,r=max;
        while(l<r){
            int m = l + (r-l)/2;
            int sum=0;
            for(int p : piles){
                sum += Math.ceil((double)p/m);
            }
            if(sum<=h)
                r=m;
            else
                l = m+1;
        }
        return r;
    }
}