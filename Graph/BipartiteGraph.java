class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
             adj.get(v).add(u); 
        }
        int []color = new int[V];
        Arrays.fill(color,-1);
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(bfs(V,i,color,adj)==false){
                    return false;
                }
            }
        }
        return true; 
    }
    boolean bfs(int V,int st,int[]color,List<List<Integer>>adj){
        Queue<Integer>q = new LinkedList<>();
        q.add(st);
        color[st] = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i=0;i<adj.get(node).size();i++){
                int cell = adj.get(node).get(i);
                if(color[cell]==-1){
                    color[cell] = 1-color[node];
                    q.add(cell);
                }else if(color[cell] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}
