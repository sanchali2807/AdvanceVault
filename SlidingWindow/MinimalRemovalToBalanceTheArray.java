class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = 0;
        int ans = n;
        // or any bigger value
        while(j<n){
            while((long)nums[i] * k < nums[j]){
                i++;
            }
             ans = Math.min(ans, n - (j - i + 1));
             j++;

        }
        return ans;
    }
}
