class CustomStack {

    int [] arr;
    int size;
    Stack<Integer> st;
    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        size = maxSize;
        st = new Stack<>();
    }
    
    public void push(int x) {
        if(st.size()<size)
            st.push(x);
    }
    
    public int pop() {
        int i = st.size()-1;
        if(i<0) return -1;
        if(i>0){
            arr[i-1] += arr[i];
        }
            int pop = arr[i]+st.pop();
            arr[i] = 0;
            return pop;
        
    }
    
    public void increment(int k, int val) {
        int i = Math.min(k, st.size()) - 1;
        if (i >= 0)
            arr[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */