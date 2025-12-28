class Solution {
    void dfs(int r,int c,char[][]board,boolean[][]vis){
        vis[r][c] = true;
        int n = board.length;
        int m = board[0].length;
        int []dr = {-1,1,0,0};
        int []dc = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && board[nr][nc] == 'O'){
                dfs(nr,nc,board,vis);
            }
        }
    }
    public void solve(char[][] board) {
         int n = board.length;
         int m = board[0].length;
         boolean[][]vis=new boolean[n][m];
         for(int j=0;j<m;j++){
            //first row and last row
            if(vis[0][j] == false && board[0][j] == 'O'){
                dfs(0,j,board,vis);
            }
            if(vis[n-1][j] == false && board[n-1][j] == 'O'){
                dfs(n-1,j,board,vis);
            }
         }
         for(int i=0;i<n;i++){
            if(vis[i][0] == false && board[i][0] == 'O'){
                dfs(i,0,board,vis);
            }
            if(vis[i][m-1] == false && board[i][m-1] == 'O'){
                dfs(i,m-1,board,vis);
            }
         }
         for(int i=0;i<n;i++){
            for(int j=0 ;j<m;j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
         }
    }
}
