class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<res.length;i++){
            while(!s.isEmpty() && temperatures[i]>temperatures[s.peek()]){
                int j = s.pop();
                res[j] = i-j;
            }
            s.push(i);
        }
        return res;
    }
}