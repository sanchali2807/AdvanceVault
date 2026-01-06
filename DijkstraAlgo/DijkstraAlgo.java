class Solution {
class pair{
    int n ;
    int d;
    pair(int n,int d){
        this.n = n;
        this.d = d;
    }
}
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int d = edges[i][2];
            adj.get(u).add(new pair(v, d));
            adj.get(v).add(new pair(u, d));
        }
        PriorityQueue<pair>pq =  new PriorityQueue<>((a, b) -> a.d - b.d);
        int[]dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        pq.add(new pair(src,0));
        while(!pq.isEmpty()){
            pair node = pq.poll();
            int u = node.n;
            int dis = node.d;
              for (pair nbr : adj.get(u)) {
                int v = nbr.n;
                int wt = nbr.d;
            if(dist[u]+wt < dist[v]){
                dist[v] = dist[u]+wt;
                pq.add(new pair(v,dist[v]));
            }
        }}
        return dist;
    }
}
