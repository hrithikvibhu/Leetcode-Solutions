class Solution {
    public String removeDuplicateLetters(String s) {
       int[] map = new int[26];
        for(char c:s.toCharArray()){
            map[c-'a']++;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for(char c : s.toCharArray()){
            int i = c-'a';
            map[i]--;
            if(visited[i])
                continue;
            while(!stack.isEmpty() && stack.peek()>c && map[stack.peek()-'a']>0){
                char remove = stack.pop();
                visited[remove-'a'] = false;
            }
            stack.push(c);
            visited[i] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }
}