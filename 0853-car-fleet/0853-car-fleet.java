class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int ans = 0;
        int n = position.length;
        int[][] map = new int[n][2]; 
        for(int i=0;i<n;i++){
            map[i][0] = position[i];
            map[i][1] = speed[i];
        }
        double prev = 0;
        Arrays.sort(map , (a,b)->(a[0]-b[0]));
        for(int i=n-1;i>=0;i--){
            double d = target-map[i][0];
            d = d/map[i][1]*1.0;
            if(d>prev){
                prev = d;
                ans++;
            }
        }
        return ans;
    }
}