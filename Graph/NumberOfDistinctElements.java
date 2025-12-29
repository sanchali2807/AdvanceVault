// User function Template for Java

class Solution {
    public void dfs(int r,int c,int[][]grid,boolean[][]vis,List<Integer>list,int st,int end){
        vis[r][c] = true;
        int n = grid.length;
        int m = grid[0].length;
        list.add(r-st);
        list.add(c-end);
        int[]dr = {-1,1,0,0};
        int[]dc = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc]==1){
                dfs(nr,nc,grid,vis,list,st,end);
            }
        }
    }
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][]vis = new boolean[n][m];
        Set<List<Integer>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              List<Integer> l = new ArrayList<>();
                if(!vis[i][j] && grid[i][j] == 1){
                    dfs(i,j,grid,vis,l,i,j);
                    st.add(l);
                }
            }
        }
        return st.size(); 
    }
}
