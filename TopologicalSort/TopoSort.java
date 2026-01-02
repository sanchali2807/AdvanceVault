class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            }
            
        boolean[]vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,adj,st);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        return res;
        
    }
    void dfs (int node , boolean[]vis,List<List<Integer>> adj,Stack<Integer> st ){
        vis[node] = true;
        for(int i=0;i<adj.get(node).size();i++){
            int n = adj.get(node).get(i);
            if(!vis[n]){
                dfs(n,vis,adj,st);
            }
        }
        st.add(node);
    }
}
