class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int idx = 0;
        int min = nums.length+1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                idx = i;
            min = Math.min(min,Math.abs(idx - start));
            // if we write this line outisde if the idx is not changes at the first try thn 
            // min will be 0 as idx is 0 and then the drfault answer will be 0 as it is the min
            }
        }
        return min;
    }
}
