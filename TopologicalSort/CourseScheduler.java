class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(u).add(v);
        }
        int []indegree = new int[n];
       for(int i=0;i<n;i++){
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
       if(c==n){
           return true;
       }
       return false;
}}
