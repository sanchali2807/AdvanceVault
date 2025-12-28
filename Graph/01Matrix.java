class Solution {
    class Pair{
        int r;
        int c;
        int d;
        Pair(int r,int c,int d){
            this.c=c;
            this.r=r;
            this.d=d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][]dis = new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        int[]dr={-1,1,0,0};
        int[]dc={0,0,-1,1};
        while(!q.isEmpty()){
            Pair cell = q.poll();
            int r = cell.r;
            int c = cell.c;
            int d = cell.d;
            dis[r][c] = d;
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==false){
                    vis[nr][nc]=true;
                    q.add(new Pair(nr,nc,d+1));
                    }
            }

        }
        return dis;
        }
}
