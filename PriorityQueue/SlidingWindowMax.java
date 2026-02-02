class Solution {
    class pair{
        int num;
        int index;
        pair(int num,int index){
            this.num = num;
            this.index = index;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<pair>pq = new PriorityQueue<>((a,b)->b.num - a.num);
        int r = 0;
        int l = 0;
        int n = nums.length;
        int i=0;
        int[]res = new int[n-k+1];
        while(r<n){
            pq.add(new pair(nums[r],r));
            if(r-l+1 == k){
                while(pq.peek().index < l){
                    pq.poll();
                }
                res[i++] = pq.peek().num;
                l++;
            }
            r++;
        }
        return res;
    }
}
