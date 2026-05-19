class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        int jump =0;
        int currEnd = 0;
        for(int i=0;i<n-1;i++){
            farthest = Math.max(farthest,nums[i] + i);
            if(i == currEnd){
                jump++;
                currEnd = farthest;
            }
        }
        return jump;
    }
}
