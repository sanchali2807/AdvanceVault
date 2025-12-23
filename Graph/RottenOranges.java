class Solution {
    class pair{
        int r;
        int c;
        int t;
        pair(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair>q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new pair(i,j,0));
                }
            }
        }
        int[]dr = {-1,1,0,0};
        int[]dc = {0,0,-1,1};
        int time = 0;
        while(!q.isEmpty()){
            pair cell = q.poll();
            int r = cell.r;
            int c = cell.c;
            int t = cell.t;
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]!=0 && grid[nr][nc]!=2){
                    grid[nr][nc] = 2;
                    q.add(new pair(nr,nc,t+1));
                }
            }
            time = t;

        }
        for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(grid[i][j] == 1){
                return -1;
        }
    }
}
        return time;
    }
}
