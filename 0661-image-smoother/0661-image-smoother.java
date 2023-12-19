class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] res = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              int sum = 0;
                int count = 0;
                for(int ir : new int[]{-1,0,1}){
                    for(int ic : new int[]{-1,0,1}){
                        if(isValid(i+ir,j+ic,n,m)){
                            count++;
                            sum += img[i+ir][j+ic];
                        }
                    }
                }
                res[i][j] = sum/count;
            }
        }
        return res;
    }
    
    public boolean isValid(int i,int j , int n,int m){
        return i>=0 && j>=0 && i<n &&j<m;
    }
}