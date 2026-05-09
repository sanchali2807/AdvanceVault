class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<=n-3;i++){
            if(nums[i] == 0){
                for(int j = i ; j < i+3;j++){
                    nums[j] ^= 1;
                }
                count++;
            }
        }
        if(nums[n-1] == 0|| nums[n-2] == 0)return -1;
        return count;
    }
}
