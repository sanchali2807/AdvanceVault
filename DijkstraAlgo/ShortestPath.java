class Solution {
    class pair{
        int node;
        int d;
        pair(int node,int d){
            this.node = node;
            this.d = d;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int d = edges[i][2];
            adj.get(u).add(new pair(v,d));
            adj.get(v).add(new pair(u,d));
        }
        int[]dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b)->a.d-b.d);
        List<Integer> res = new ArrayList<>();
        int[]parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        pq.add(new pair(1,0));
        while(!pq.isEmpty()){
            pair cell = pq.poll();
            int node = cell.node;
            int d = cell.d;
            for(pair nei : adj.get(node)){
                int v = nei.node;
                int dis = nei.d;
                if(dist[node] + dis < dist[v]){
                    dist[v] = dist[node] + dis;
                    parent[v] = node;
                    pq.add(new pair(v,dist[v]));
                }
            }
            
        }
        
      
        if (dist[n] == Integer.MAX_VALUE) {
            res.add(-1);
            return res;
        }

// build path
        int node = n;
        while (parent[node] != node) {
         res.add(node);
            node = parent[node];
        }
        res.add(node);
        Collections.reverse(res);

// add distance at front
        res.add(0, dist[n]);

        return res;
        
    }
}
