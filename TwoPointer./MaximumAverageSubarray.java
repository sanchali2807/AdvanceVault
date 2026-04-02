class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        double max = Double.NEGATIVE_INFINITY;
        int sum = 0;
        while(r<n){
             sum += nums[r];
            if(r-l+1 == k){
                max = Math.max(max,(double)sum/k);
                sum = sum - nums[l];
                l++;
            }
            r++;
        }
        return max;
    }
}
