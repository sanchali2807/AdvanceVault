class Solution {
    public boolean isCyclic(int V, int[][] edges) {
       
         List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
             
        }
       int []indegree = new int[V];
       for(int i=0;i<V;i++){
           for(int j : adj.get(i)){
               indegree[j]++;
           }
       }
       Stack<Integer> st = new Stack<>();
       for(int i=0;i<indegree.length;i++){
           if(indegree[i]==0){
               st.push(i);
           }
       }
       int c = 0;
       while(!st.isEmpty()){
           int node = st.pop();
           c++;
           for(int u : adj.get(node)){
               indegree[u]--;
               if(indegree[u]==0){
                   st.push(u);
               }
           }
       }
       if(c<V){
           return true;
       }
       return false;

    }
   
}
