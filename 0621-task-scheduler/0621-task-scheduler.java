class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int[] map = new int[26];
        for(char c : tasks)
            map[c-'A']++;
        for(int m : map){
            if(m>0) pq.offer(m);
        }
        
        int res=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            res++;
            if(!pq.isEmpty()){
                int count = pq.poll();
                count--;
                if(count>0)
                    q.offer(new Pair(count,res+n));
            }
            if(!q.isEmpty() && q.peek().getValue() == res){
                pq.add(q.poll().getKey());
            }
        }
        return res;
    }
}