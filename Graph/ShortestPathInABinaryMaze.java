// User function Template for Java

class Solution {
     class pair{
        int r;
        int c;
        int d;
        pair(int r,int c,int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    int shortestPath(int[][] mat, int[] source, int[] destination) {
        int n = mat.length;
        int m = mat[0].length;
        int srcR = source[0];
        int srcC = source[1];
        int destR = destination[0];
        int destC = destination[1];
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(srcR,srcC,0));
        boolean[][]vis = new boolean[n][m];
        vis[srcR][srcC] = true;
        while(!q.isEmpty()){
            pair cell = q.poll();
            int r = cell.r;
            int c = cell.c;
            int d = cell.d;
            if(r==destR && c == destC){
                return d;
            }
            int []dr = {-1,1,0,0};
            int []dc = {0,0,-1,1};
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && mat[nr][nc] == 1){
                    vis[nr][nc] = true;
                    q.add(new pair(nr,nc,d+1));
                }
            }
        }
            return -1;
        
    }
}
