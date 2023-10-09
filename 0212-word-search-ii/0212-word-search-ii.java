class Solution {
    Node root ;
    List<String> res ;
    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        res = new ArrayList<>();
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<words.length;i++)
            insert(words[i]);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i,j,n,m,root,board);
            }
        }
        
        return res;
    }
    
    private void dfs(int i,int j,int n,int m , Node curr , char[][] board){
       if(i<0 || i>=n || j<0 || j>=m || board[i][j] == '0')
           return ;
        
        char c = board[i][j];
        
        int pos = c-'a';
        if(curr.children[pos] == null)
            return;
        curr = curr.children[pos];
        if(curr.word!=null){
            res.add(curr.word);
            curr.word = null;
        }
        
        board[i][j] = '0';
        dfs(i+1,j,n,m,curr,board);
        dfs(i-1,j,n,m,curr,board);
        dfs(i,j-1,n,m,curr,board);
        dfs(i,j+1,n,m,curr,board);
        board[i][j] = c;
    }
    
    private void insert(String word){
        Node curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new Node();
            
            curr = curr.children[c-'a'];
        }
        curr.word = word;
    }
    
    class Node{
        Node[] children = new Node[26];
        String word ;
    }
}