class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxL = height[0] , maxR = height[n-1];
        int res = 0;
        int l = 0,r=n-1;
        while(l<r){
            if(maxL<maxR){
                l++;
                maxL = Math.max(maxL,height[l]);
                res += maxL - height[l];
            }
            else{
                r--;
                maxR = Math.max(maxR,height[r]);
                res += maxR - height[r];
            }
        }
        return res;
    }
}