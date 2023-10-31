class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 1;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        if(!wordList.contains(endWord)) return 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0){
                String curr = q.poll();
                if(curr.equals(endWord)) return res;
                for(int i=0;i<curr.length();i++){
                    char[] c = curr.toCharArray();
                    for(char k='a';k<='z';k++){
                        c[i]= k;
                        String temp = new String(c);
                        if(set.contains(temp)&& !visited.contains(temp)){
                            q.add(temp);
                            visited.add(temp);
                        }
                    }
                }
                
            }
            res++;
        }
        return 0;
    }
}