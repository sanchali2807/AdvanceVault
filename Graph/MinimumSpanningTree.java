class Solution {
    class pair{
        int node;
        int d;
        pair(int node,int d){
            this.node = node;
            this.d = d;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<pair>>adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new pair(v, w));
            adj.get(v).add(new pair(u, w));
        }
        boolean[]vis = new boolean[V];
        int sum = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.d,b.d));
        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            pair cell = pq.poll();
            int node = cell.node;
            int dis = cell.d;
            if(vis[node])continue;
            vis[node] = true;
            sum += dis;
            for(pair nei : adj.get(node)){
                int n = nei.node;
                int wt = nei.d;
                if(!vis[n]){
                 pq.add(new pair(n,wt));
            }
        }
    }
        return sum;
}
}
