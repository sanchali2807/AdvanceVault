class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        int count = 0;
        int[]pow1= new int[n];
        pow1[0] = 1;
        for(int i=1;i<n;i++){
            pow1[i] = (pow1[i-1] * 2)%mod;
        }
        while(l<=r){
            if(nums[l] + nums[r] > target){
                r--;
            }else{
                count = (count + pow1[r-l])%mod;
                l++;
            }
        }
        return count;
    }
}
