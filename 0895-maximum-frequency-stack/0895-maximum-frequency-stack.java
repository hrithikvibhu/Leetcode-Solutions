class FreqStack {

    
    Map<Integer,Integer> map = new HashMap<>();
    Map<Integer,List<Integer>> stacks = new HashMap<>();
    int max = 0;
    public FreqStack() {
        
    }
    
    public void push(int val) {
        int val_freq = map.getOrDefault(val,0)+1;
        map.put(val,val_freq);
        if(val_freq>max){
            max = val_freq;
            stacks.put(max , new ArrayList<>());
        }
        
        List<Integer> stack = stacks.get(val_freq);
        stack.add(val);
        stacks.put(val_freq,stack);
    }
    
    public int pop() {
        // for(int key : stacks.keySet()){
        //     System.out.println(key);
        //     for(Integer i:stacks.get(key)){
        //         System.out.print(i +" ");
        //     }
        //     System.out.println("\n");
        // }
        List<Integer> stack = stacks.get(max);
        int res = stack.remove(stack.size()-1);
        map.put(res , map.getOrDefault(res,0)-1);
        if(stack.size()==0)
            max --;
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */