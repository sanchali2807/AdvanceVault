class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        Queue<Integer> q = new LinkedList<>();
        boolean [] vis = new boolean [n];
        ArrayList<Integer> list = new ArrayList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int node = q.poll();
                list.add(node);
                for(int i=0;i<adj.get(node).size();i++){
                    int ne = adj.get(node).get(i);
                    if(vis[ne]==false){
                        q.add(ne);
                        vis[ne]=true;
                    }
            }
        }
        return list;
    }
}
