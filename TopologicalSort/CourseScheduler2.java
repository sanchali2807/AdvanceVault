class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
         List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(v).add(u);
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
       List<Integer>res=new ArrayList<>();
       while(!st.isEmpty()){
           int node = st.pop();
           res.add(node);
           for(int u : adj.get(node)){
               indegree[u]--;
               if(indegree[u]==0){
                   st.push(u);
               }
           }
       }
       if (res.size() != n) {
            return new int[0];
        }

       
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = res.get(i);
        }

        return ans;
       
    }
}
