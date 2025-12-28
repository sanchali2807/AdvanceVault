class Solution {
    class Pair{
        int r;
        int c;
        int d;
        Pair(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][]vis=new boolean[n][m];
        ArrayList<ArrayList<Integer>>dis = new ArrayList<>();
        Queue<Pair>q =new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(0); 
            }
                dis.add(row);
        }
            int[]dr = {-1,1,0,0};
            int[]dc= {0,0,-1,1};
        
        while(!q.isEmpty()){
            Pair cell = q.poll();
            int r = cell.r;
            int c = cell.c;
            int d = cell.d;
            dis.get(r).set(c, d);
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
