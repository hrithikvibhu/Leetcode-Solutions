class Solution {
    /*
    011101
    111121
    443211
    */
    public int maxScore(String s) {
        int n = s.length();
        int z=0,o=0;
        int[] zeroes = new int[n];
        int[] ones = new int[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                z++;
            }
            zeroes[i] = z;
        }
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='1'){
               o++;
            }
            ones[i] = o;
        }
        int res = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            res = Math.max(res , zeroes[i-1]+ones[i]);
        }
        return res;
    }
}