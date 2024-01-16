class RandomizedSet {
    
    Map<Integer,Integer> map ;
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();
    public RandomizedSet() {
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        else{
            map.put(val,list.size());
            list.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int last = list.get(list.size()-1);
            int loc = map.get(val);
            list.set(loc,last);
            map.put(last,loc);
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
        else{
            return false;
        }
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */