class Solution {
    class Pair{
        int num;
        int freq;
        Pair(int num,int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int [] res = new int[k];
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)-> b.freq - a.freq);
          for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));
        }
        int idx=0;
        while(k-- > 0){
            res[idx++] = pq.poll().num;
        }
        return res;

    }
}
