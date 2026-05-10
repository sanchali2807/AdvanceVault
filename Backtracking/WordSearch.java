class Solution {
    boolean search(int i,int j,int n,int m,char[][]board,String word,int idx,boolean[][]visited){
        if(idx == word.length())return true;
        if(i < 0 || j < 0 || i >=n || j>= m || visited[i][j] || word.charAt(idx) != board[i][j])return false;
        if(idx == word.length() - 1){ // it is here because if the character matched and it is the last index then it should return true
    return true;
}
        int[]dx = {0,0,-1,1};
        int[]dy = {-1,1,0,0};
        visited[i][j] = true;
        for(int a = 0 ; a < 4 ; a++){
            int nr = i + dx[a];
            int nc = j + dy[a];
            if(nr>=0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc]){
                if(search(nr,nc,n,m,board,word,idx+1,visited)){
                    return true;
                }
            }
        }
        visited[i][j] = false;
    return false;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(search(i,j,n,m,board,word,0,visited)){
                    return true;
                }
            }
        }
        return false;
        
    }
}
