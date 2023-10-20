class Solution {
    int n,m;
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(board[i][j]=='O' && (i==0||j==0||i==n-1||j==m-1))
                    dfs(i,j,board);
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == '-') board[i][j] = 'O';
                else board[i][j] = 'X';
                
            }
        }
    }
    
    
    private void dfs(int i,int j , char[][] board){
        if(i<0||j<0||i>=n||j>=m||board[i][j]!='O')
            return;
        board[i][j] = '-';
        
        dfs(i+1,j,board);
        dfs(i,j-1,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
    }
}