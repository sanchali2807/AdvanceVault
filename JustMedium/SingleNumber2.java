class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer>mp = new HashMap<>();
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>e:mp.entrySet()){
            if(e.getValue() == 1){
                ans = e.getKey();
            }
        }
        return ans;
    }
}
