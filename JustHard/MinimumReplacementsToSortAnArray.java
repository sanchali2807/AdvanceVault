class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        int temp = nums[n-1];
        long operation = 0;
        for(int i = n-2;i>=0;i--){
            if(nums[i] > temp){
                int parts = (nums[i] + temp - 1)/temp;
                operation += parts - 1;
                temp = nums[i] / parts;
            }else{
                temp = nums[i];
            }
        }
        return operation;
    }
}
