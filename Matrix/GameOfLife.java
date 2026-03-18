class Solution {
    boolean check(int[][]board,int i,int j,int n,int m){
        int[]dr = {-1,-1,-1,0,0,1,1,1};
        int[]dc = {-1,0,1,1,-1,0,-1,1};
            int count = 0;
        for(int d = 0 ;d < 8 ;d++){
            int nr = i + dr[d];
            int nc = j + dc[d];
            if(nr>=0 && nc >=0 && nr<n && nc < m){
                if(board[nr][nc] == 1){
                    count++;
                }
            }
        }
        if(board[i][j] == 0){
            if(count !=3)return false;
        }
        if(board[i][j] == 1){
            if(count < 2)return false;
            else if(count > 3)return false;
        }
        return true;
    }
    
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int [][]ans = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(check(board,i,j,n,m)){
                    ans[i][j] = 1;
                }else{
                    ans[i][j] = 0;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j] = ans[i][j];
            }
        }
    }
}
