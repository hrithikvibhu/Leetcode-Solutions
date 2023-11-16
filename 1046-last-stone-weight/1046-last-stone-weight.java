class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        for(int s : stones)
            q.offer(s);
        
        while(q.size()>1){
           int y = q.poll();
            int x = q.poll();
            if(x==y)
                continue;
            else
                q.offer(Math.abs(x-y));
        }
        if(q.size()==1)
            return q.poll();
        return 0;
    }
}