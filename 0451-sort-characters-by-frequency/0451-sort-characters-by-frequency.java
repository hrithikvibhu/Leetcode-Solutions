class Solution {
    public String frequencySort(String s) {
        Map<Character , Integer > map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c , map.getOrDefault(c,0)+1);
        
        PriorityQueue<Character> q = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        q.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
	    while (!q.isEmpty()) {
		    char c = q.poll();
		    for (int i = 0; i < map.get(c); i++) {
			    sb.append(c);
		    }
	    }
	    return sb.toString();
    }
}