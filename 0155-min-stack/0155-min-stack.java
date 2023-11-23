class MinStack {
    
    public class Node{
        int val;
        int min ;
        Node(int val , int min){
            this.val = val;
            this.min = min;
        }
    }
    
    List<Node> list;
    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        if(list.isEmpty()){
            list.add(new Node(val,val));
        }
        else{
            list.add( new Node(val , Math.min(list.get(list.size()-1).min , val) ));
        }
    }
    
    public void pop() {
        list.remove(list.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1).val;
    }
    
    public int getMin() {
        return list.get(list.size()-1).min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */