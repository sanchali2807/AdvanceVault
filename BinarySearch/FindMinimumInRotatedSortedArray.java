class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l<r){
            int m = l + (r - l)/2;
            if(nums[m] > nums[r]){
                l = m + 1;
            }else{
                r = m;
                // we do not do m-1 because min can also be present at mid 
            }
        }
        return nums[r];
    }
}
