class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        Queue<Integer> q = new PriorityQueue<>();
        for(int h : hand)
            q.offer(h);
        
        while(!q.isEmpty()){
            int number = q.poll();
            for(int i=1;i<groupSize;i++){
                if(!q.remove(i+number)) return false;
                else continue;
            }
        }
        return true;
    }
}