class Solution {  
    class pair{
        int node;
        int dis;
        pair(int node,int dis){
            this.node = node;
            this.dis = dis;
        }
    }
    class triplet{
        int first;
        int second;
        int third;
        triplet(int first,int second,int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
        }
        int[]distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;
        Queue<triplet>q = new LinkedList<>();
        q.add(new triplet(0,src,0));
        // stops,src,dist
        while(!q.isEmpty()){
            triplet cell = q.poll();
            int s = cell.first;
            int c = cell.second;
            int d = cell.third;
            if(s>k)continue;
            for(pair node : adj.get(c)){
                int n1 = node.node;
                int d2 = node.dis;
                if(d + d2 < distance[n1] && s <= k){
                    distance[n1] = d  + d2;
                    q.add(new triplet(s+1,n1,distance[n1]));
                }
            }
        }
        
        if(distance[dst] == Integer.MAX_VALUE)return -1;
        return distance[dst];
        
        
        
    }
}
