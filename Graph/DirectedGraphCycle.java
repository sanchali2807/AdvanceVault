class Solution {
    public boolean isCyclic(int V, int[][] edges) {
       
         List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            //  adj.get(v).add(u); 
        }
        boolean []vis = new boolean[V];
        int [] path =  new int[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(vis,path,i,adj)){
                    return true;
                }
            }
        }
        return false;

    }
    boolean dfs (boolean[]vis,int[]path,int node , List<List<Integer>>adj){
        vis[node]=true;
        path[node]=1;
        for(int i=0;i<adj.get(node).size();i++){
            int n = adj.get(node).get(i);
            if(!vis[n]){
                if(dfs(vis,path,n,adj)){
                    return true;
                }
            }else if(path[n] == 1){
                return true;
            }
        }
        path[node] = 0;
        return false;
    }
}
