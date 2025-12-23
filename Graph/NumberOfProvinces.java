class Solution {
    public int findCircleNum(int[][] graph) {
        int v = graph.length;
        int count = 0;
        boolean[]vis = new boolean[v];
        for(int i=0;i<v;i++){
            if(vis[i]==false){
                dfs(i,vis,graph);
                count++;
            }
        }
      return count;
    }
    public void dfs(int i,boolean[]vis,int[][]graph){
        vis[i] = true;
        int v = graph.length;
        for(int j=0;j<v;j++){
            if(graph[i][j]==1 && !vis[j]){
                dfs(j,vis,graph);
            }
        }
    }
}
