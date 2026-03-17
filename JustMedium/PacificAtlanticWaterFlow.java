class Solution {
    public void dfs(boolean[][]visited,int i,int j,int[][]heights){
        int r = heights.length;
        int c = heights[0].length;
        if(visited[i][j])return;
        visited[i][j] = true;
        int[]dr = {0,0,-1,1};
        int[]dc = {-1,1,0,0};
        for(int d=0;d<4;d++){
            int nr = dr[d] + i;
            int nc = dc[d] + j;
            if(nr>=0 && nc>=0 && nr<r && nc<c && !visited[nr][nc] && heights[nr][nc] >= heights[i][j]){
                dfs(visited,nr,nc,heights);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        boolean[][]visitedP = new boolean[r][c];
        boolean[][]visitedA = new boolean[r][c];
        //top
        for(int i=0;i<r;i++){
           dfs(visitedP,i,0,heights);
        }
        //left
        for(int j=0;j<c;j++){
            dfs(visitedP,0,j,heights);
        }
        //right
        for(int i=0;i<r;i++){
            dfs(visitedA,i,c-1,heights);
        }
        //bottom
        for(int j=0;j<c;j++){
            dfs(visitedA,r-1,j,heights);
        }
        List<List<Integer>>list = new ArrayList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(visitedA[i][j] && visitedP[i][j]){
                    List<Integer> a = new ArrayList<>();
                    a.add(i);
                    a.add(j);
                    list.add(a);
                }
            }
        }
        return list;
    }
}
