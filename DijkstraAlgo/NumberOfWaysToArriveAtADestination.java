class Solution {
    class pair{
        int node;
        long time;
        pair(int node,long time){
            this.node = node;
            this.time = time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i< n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new pair(roads[i][0],roads[i][2]));
        }
         long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.time,b.time));
        int MOD = 1_000_000_007;

        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            pair node = pq.poll();
            int a = node.node;
            long t = node.time;
             if (t > dist[a]) continue;
            for(pair nei : adj.get(a)){
                int value = nei.node;
                long newTime = nei.time;
                if(t + newTime < dist[value]){
                    dist[value] = t + newTime;
                    ways[value] = ways[a];
                     pq.add(new pair(value, dist[value]));
                }else if(dist[a]+newTime == dist[value]){
                    ways[value] = (ways[value]+ways[a])%MOD;
                }
            }
        }
        return (int)ways[n-1];
    }
}
