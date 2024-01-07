class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l =0 ,r= n-1;
        int res = 0;
        int maxL = height[0];
        int maxR = height[n-1];
        while(l<r){
            int area = 0;
            if(maxL<maxR){
                l++;
                 area = maxL-height[l];
                maxL = Math.max(maxL,height[l]);
               
            }
            else{
                r--;
                 area = maxR-height[r];
                maxR = Math.max(maxR,height[r]);
               
            }
             if(area>0) res += area;
        }
        return res;
    }
}