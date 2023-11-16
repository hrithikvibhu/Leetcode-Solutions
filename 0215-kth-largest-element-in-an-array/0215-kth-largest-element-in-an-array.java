class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        for(int n:nums)
            q.offer(n);
        int ans=0;
        for(int i=0;i<k;i++){
            ans = q.poll();
        }
        return ans;
    }
}