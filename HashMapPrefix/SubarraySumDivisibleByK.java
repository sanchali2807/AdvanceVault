class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int sum = 0;
        int count=0;
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int rem = sum % k;
            // sum till j - sum till i if divisible by k increase count
            // so it can be written as
            // sum(j) % k = sum(i) %i;
            // so if remainder is same we add;
            if(rem<0){
                rem += k;
            }
            count += mp.getOrDefault(rem,0);
            mp.put(rem,mp.getOrDefault(rem,0)+1);
        }
        return count;
    }
}
