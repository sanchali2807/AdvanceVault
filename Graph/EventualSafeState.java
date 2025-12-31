class Solution {
    boolean dfs(boolean[]vis,boolean[]check,boolean[]path, List<List<Integer>>adj,int st){
        vis[st] = true;
        path[st] = true;
        check[st] = false;
        for(int i=0;i<adj.get(st).size();i++){
            int node = adj.get(st).get(i);
            if(!vis[node]){
                if(dfs(vis,check,path,adj,node))return true;
            }else if(path[node]){
                return true;
            }
        }
            path[st] = false;
            check[st] = true;
            return false;
    }
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
          boolean[]check = new boolean[V];
          boolean[]path = new boolean[V];
          boolean[]vis = new boolean[V];
          List<List<Integer>>adj=new ArrayList<>();
          for(int i=0;i<V;i++){
              adj.add(new ArrayList<>());
          }
          for(int i=0;i<edges.length;i++){
              int u = edges[i][0];
              int v = edges[i][1];
              adj.get(u).add(v);
          }
          for(int i=0;i<V;i++){
              if(!vis[i]){
                 dfs(vis,check,path,adj,i);
              }
          }
          ArrayList<Integer> res = new ArrayList<>();
          for(int i=0;i<V;i++){
              if(check[i] == true){
                  res.add(i);
              }
          }
          return res;
    }
}
