class Solution {
    public class Node{
        Node[] next = new Node[26];
        String word = null;
    }
    
    Node root;
    int n,m;
    Set<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        root = new Node();
        for(String str : words){
            insert(str);
        }
        n = board.length;
        m = board[0].length;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                dfs(i,j,root,board);
        
        return new ArrayList<>(res);
    }
    
    public void insert(String word){
        Node curr = root;
        for(char c : word.toCharArray()){
            if(curr.next[c-'a']==null)
                curr.next[c-'a'] = new Node();
            
            curr = curr.next[c-'a'];
        }
        curr.word = word;
    }
    
    
    public void dfs(int i, int j , Node curr , char[][] board){
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]=='.') return;
        
        char c = board[i][j];
        Node next = curr.next[c-'a'];
        if(next==null) return;
        
        curr = next;
        if(curr.word!=null){
            res.add(curr.word);
            
        }
        
        board[i][j] = '.';
        dfs(i+1,j,curr,board);
        dfs(i,j+1,curr,board);
        dfs(i-1,j,curr,board);
        dfs(i,j-1,curr,board);
        board[i][j] = c;
    }
    
}