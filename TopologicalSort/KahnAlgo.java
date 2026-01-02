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
            
            int [] indegree = new int[V];
            for(int i=0;i<V;i++){
                for(int j : adj.get(i)){
                    indegree[j]++ ;
                }
            }
        boolean[]vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
       for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int i=0;i<adj.get(node).size();i++){
                int n = adj.get(node).get(i);
                indegree[n]--;
                if(indegree[n]==0){
                    q.add(n);
                }
            }
        }
        return res;
        
    }
}
