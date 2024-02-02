class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=9;i++)
            q.offer(i);
        
        while(!q.isEmpty()){
            int num = q.poll();
            if(num>high)
                continue;
            if(num>=low && num<=high)
                res.add(num);
            int ones = num%10;
            if(ones<9){
                q.offer(num*10 + (ones+1));
            }
        }
        return res;
    }
}