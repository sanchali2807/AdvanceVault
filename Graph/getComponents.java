class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         for(int i=0;i<V;i++){
             adj.add(new ArrayList<>());
         }
         for(int []e : edges){
             int u = e[0];
             int v = e[1];
             adj.get(u).add(v);
             adj.get(v).add(u);
         }
        boolean[]vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                ArrayList<Integer> list = new ArrayList<>();
                dfs(adj,list,i,vis);
                res.add(list);
            }
        }
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer>list,int node,boolean[]vis){
        if(vis[node])return;
        vis[node] = true;
        list.add(node);
        for(int i : adj.get(node)){
            if(!vis[i]){
                dfs(adj,list,i,vis);
        }
    }}}
