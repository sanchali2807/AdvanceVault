class Solution {
    class pair{
        double val;
        int idx ;
        pair(double val,int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    public double minMaxDist(int[] stations, int K) {
        // code here
        int n = stations.length;
        if(n == 1)return 0.00;
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b)->Double.compare(b.val,a.val));
        int[]placed = new int[n];
        for(int i=0;i<n-1;i++){
            double diff = stations[i+1] - stations[i]; 
            pq.add(new pair(diff,i));
        }
        for(int i = 1;i<=K;i++){
            pair node = pq.poll();
            int idx = node.idx;
            double diff = stations[idx+1] - stations[idx];
            placed[idx]++;
            double newDiff = diff / (placed[idx] + 1);
            pq.add(new pair(newDiff,idx));
        }
        return pq.poll().val;
    }
}
