class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> s = new Stack<>();
        int res = 0;
        for(int i=0;i<heights.length;i++){
            int j = i;
            while(!s.isEmpty() && s.peek()[1]>heights[i]){
                int[] a = s.pop();
                res = Math.max(res,a[1]*(i-a[0]));
                j = a[0];
            }
            s.push(new int[]{j,heights[i]});
        }
        while(!s.isEmpty()){
            int[] a = s.pop();
            res = Math.max(res , (heights.length-a[0])*a[1]);
        }
        return res;
    }
}