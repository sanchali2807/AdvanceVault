// User function Template for Java
class Solution {
class Pair {
    int v;
    int wt;

    Pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}
    public void dfs(int node,List<List<Pair>>adj,boolean[]vis,Stack<Integer>st){
        vis[node]=true;
        for(Pair i : adj.get(node)){
            int v = i.v;
            if(!vis[v]){
                dfs(v,adj,vis,st);
            }
        }
        st.add(node);
     }
    public int[] shortestPath(int V, int E, int[][] edges) {
        
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,vis,st);
            }
        }
        int distance[] = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
              if (distance[node] != Integer.MAX_VALUE) {
                for (Pair p : adj.get(node)) {
                    if (distance[node] + p.wt < distance[p.v]) {
                        distance[p.v] = distance[node] + p.wt;
                    }
                }
            }
        }
         for (int i = 0; i < V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
 
        return distance;
    }
}
