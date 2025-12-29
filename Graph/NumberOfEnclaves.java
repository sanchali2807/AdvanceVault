class Solution {
    void dfs(int r,int c,boolean[][]vis,int[][]grid){
        vis[r][c] = true;
        int n = grid.length;
        int m = grid[0].length;
        int[]dr = {-1,1,0,0};
        int[]dc = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc] == 1){
                dfs(nr,nc,vis,grid);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][]vis = new boolean[n][m];
        for(int j=0;j<m;j++){
            if(grid[0][j] == 1 && !vis[0][j]){
                dfs(0,j,vis,grid);
            }
            if(grid[n-1][j] == 1 && !vis[n-1][j]){
                dfs(n-1,j,vis,grid);
            }
        }
    
        for(int i=0;i<n;i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                dfs(i,0,vis,grid);
            }
            if(grid[i][m-1]==1 && !vis[i][m-1]){
                dfs(i,m-1,vis,grid);
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}
