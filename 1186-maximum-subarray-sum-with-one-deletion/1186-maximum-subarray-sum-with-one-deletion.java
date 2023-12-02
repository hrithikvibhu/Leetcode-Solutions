class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[] maxEndHere = new int[n];
        int[] maxEndHere2 = new int[n];
        maxEndHere[0] = maxEndHere2[0] = arr[0];
        int max = maxEndHere2[0];

        for(int i=1;i<n;i++){
            maxEndHere[i] = Math.max(arr[i] , arr[i] + maxEndHere[i-1]);
            maxEndHere2[i] = Math.max(arr[i] , arr[i] + maxEndHere2[i-1]);
            if(i>1){
                maxEndHere2[i] = Math.max(maxEndHere2[i] , arr[i] + maxEndHere[i-2]);
            }
            max = Math.max( max , maxEndHere2[i]);
        }
        return max;
    }
}