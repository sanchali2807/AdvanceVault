class Solution {
    public int smallestDivisor(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
        }
        int low = 1;
        int high = max;
        int ans = 0;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(canPlace(mid,nums,k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    boolean canPlace(int val,int[]nums,int k){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += (nums[i] + val - 1)/val;
            if(sum > k){
                return false;
            }
        }
        return true;
    }
}
