class Solution {
     static class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    static void bfs(char[][]mat,int row,int col,boolean[][]vis){
        int rows = mat.length;
        int cols = mat[0].length;
        int []dr = {1,-1,0,0};
        int []dc = {0,0,1,-1};
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        vis[row][col] = true;
        while(!q.isEmpty()){
            Pair cell = q.poll();
            int r = cell.r;
            int c = cell.c;
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr>=0 && nr<rows && nc>=0 && nc<cols && mat[nr][nc]=='1' && !vis[nr][nc]){
                vis[nr][nc]=true;
                q.add(new Pair(nr,nc));
            }
        }
    }}
    public int numIslands(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
         int count = 0;
      boolean[][]vis = new boolean[m][n];
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              if(mat[i][j]=='1' && !vis[i][j]){
                  bfs(mat,i,j,vis);
                  count++;
              }
          }
      }
      return count;
    }
}
