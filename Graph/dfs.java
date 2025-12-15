class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public void fun(ArrayList<ArrayList<Integer>> adj , boolean[]vis,int curr){
        list.add(curr);
        vis[curr]=true;
        for(int i=0;i<adj.get(curr).size();i++){
            int nei = adj.get(curr).get(i);
            if(vis[nei] == false){
                fun(adj,vis,nei);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        boolean[]vis = new boolean[n];
            fun(adj, vis,0);
            return list;
        }
}
