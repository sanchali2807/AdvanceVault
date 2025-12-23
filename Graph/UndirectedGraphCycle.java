class Solution {
    class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public boolean bfs(int node,boolean[]vis,ArrayList<ArrayList<Integer>> adj){
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(node,-1));
        vis[node]=true;
        while(!q.isEmpty()){
            Pair cell = q.poll();
            int n = cell.node;
            int p = cell.parent;
            for(int i=0;i<adj.get(n).size();i++){
                int nei = adj.get(n).get(i);
                if(!vis[nei]){
                    vis[nei]=true;
                    q.add(new Pair(nei,n));
                }else{
                    if(nei!=p){
                        return true;
                    }
                }
            }
        }
            return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        int n = edges.length;
        int m = edges[0].length;
        boolean[]vis = new boolean[V+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<>());
                }

            for(int i = 0; i < edges.length; i++){
                 int u = edges[i][0];
                 int v = edges[i][1];
                 adj.get(u).add(v);
                 adj.get(v).add(u);
}

        for(int i=0;i<V;i++){
            if(!vis[i] && bfs(i,vis,adj)){
                return true;
            }
        }
        return false;
    }
}
