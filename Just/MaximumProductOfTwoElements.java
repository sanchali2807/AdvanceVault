class Solution {
    public int maxProduct(int[] nums) {
        // Arrays.sort(nums);
        int n = nums.length;
        int l=0;
        int r=n-1;
        int mult = 1;
        int max = 0;
        while(l<r){
            mult = ((nums[l]-1) * (nums[r]-1));
            max = Math.max(mult,max);
            if(nums[l]<nums[r]){
                l++;
            }else{
                r--;
            }
            // r--;
            // l++;
        }
        return max;
    }
}
