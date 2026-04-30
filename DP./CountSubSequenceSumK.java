class Solution {
    int helper(int []arr , int target,int sum,int idx){
        if(sum > target){
            return 0;
        }
        if(sum == target){
            return 1;
        }
        if(idx >= arr.length){
            return 0;
        }
        // pick and not pick
        int pick = helper(arr,target,sum+arr[idx],idx+1);
        int notPick = helper(arr,target,sum,idx+1);
        return pick + notPick;
    }
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        return helper(nums,target,0,0);
    }
}
