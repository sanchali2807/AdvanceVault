class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
          List<List<Integer>>adj=new ArrayList<>();
          for(int i=0;i<V;i++){
              adj.add(new ArrayList<>());
          }
          int[]indegree = new int[V];
          for(int i=0;i<edges.length;i++){
              int u = edges[i][0];
              int v = edges[i][1];
              //we need to reverse the outgoing to incomming
              adj.get(v).add(u);
        
          }
          Queue<Integer> q = new LinkedList<>();
          for(int i=0;i<V;i++){
              for(int j : adj.get(i)){
                  indegree[j]++;
              }
          }
          for(int i=0;i<V;i++){
              if(indegree[i]==0){
                      q.add(i);
                  }
          }
          ArrayList<Integer> list = new ArrayList<>();
          while(!q.isEmpty()){
              int node = q.poll();
              list.add(node);
              for(int v : adj.get(node)){
                  indegree[v]--;
                  if(indegree[v] == 0){
                      q.add(v);
                  }
                  
              }
          }
          Collections.sort(list);
          return list;
    }
}
