class MedianFinder {
    
    Queue<Integer> min = new PriorityQueue<>();
    Queue<Integer> max = new PriorityQueue<>((a,b)->b-a);
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(max.size() == 0 || num<=max.peek())
            max.offer(num);
        else
            min.offer(num);
        
        if(max.size()>min.size()+1)
            min.offer(max.poll());
        else if(min.size()>max.size()+1)
            max.offer(min.poll());
    }
    
    public double findMedian() {
        if(max.size() == min.size()){
            double d = max.peek()+min.peek();
            return (double)d/2.0;
        }
        else{
            if(max.size()>min.size()) return max.peek();
            else return min.peek();
        }
            
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */