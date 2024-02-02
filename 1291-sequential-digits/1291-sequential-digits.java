class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        // return method1(low,high);
        
        int low_len = Integer.toString(low).length();
        int high_len = Integer.toString(high).length();
        System.out.println(low_len + " " + high_len);
        List<Integer> res = new ArrayList<>();
        for(int digits=low_len;digits<=high_len;digits++){
            for(int start = 1;start<9;start++){
                if(start+digits>10)
                    break;
                
                int num = start;
                int prev = start;
                for(int j=0;j<digits-1;j++){
                    num = num*10;
                    prev++;
                    num += prev;
                    // System.out.println(num);
                }
                if(num>=low && num<=high)
                        res.add(num);
                
            }
        }
        return res;
        
    }
    
    public List<Integer> method1(int low , int high){
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