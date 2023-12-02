class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int oneDel = 0 , noDel = arr[0];
        int max = arr[0];
        for(int i=1;i<n;i++){
            oneDel = Math.max(noDel , oneDel + arr[i]);
            noDel = Math.max(noDel+arr[i] , arr[i]);
            max = Math.max( max , Math.max(noDel , oneDel));
        }
        return max;
    }
}