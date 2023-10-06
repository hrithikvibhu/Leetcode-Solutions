class Solution {
     Map<Integer, Integer> map = new HashMap<>();
    
    public int integerBreak(int n) {
        if (map.containsKey(n)) return map.get(n);
        
        int res = Integer.MIN_VALUE;
        if (n == 1) {
            return 1;
        } 
        
        for(int i = 1; i <= n / 2; i++) {
            res = Math.max(res, i * Math.max(n-i, integerBreak(n-i)));
        }
        
        map.put(n, res);
        return map.get(n);
    }
}