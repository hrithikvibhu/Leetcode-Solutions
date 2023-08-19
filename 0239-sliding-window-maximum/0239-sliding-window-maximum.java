class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0 , r= 0;
        
        int i=0;
        
        while(r<n){
            while(!q.isEmpty() && q.peek()<l)
                q.pollFirst();
            
            while(!q.isEmpty() && nums[q.peekLast()]<nums[r])
                q.pollLast();
            
            q.offer(r);
            
            if(r-l+1 ==k){
                res[i++] = nums[q.peek()];
                l++;
            }
            r++;
        }
        return res;
    }
}