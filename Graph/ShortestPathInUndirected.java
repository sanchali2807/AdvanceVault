class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[]distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int v : adj.get(node)){
                if(distance[node]!=Integer.MAX_VALUE){
                if(distance[node] + 1 < distance[v]){
                    distance[v] = distance[node] + 1;
                    q.add(v);
                }
            }
            }
        }
            for(int i=0;i<V;i++){
                if(distance[i]==Integer.MAX_VALUE){
                    distance[i] = -1;
                }
            }
            
        return distance;
    }
}
