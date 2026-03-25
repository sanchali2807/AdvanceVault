class Solution {
    public boolean subsetSum(int target,int[]nums,int idx,int sum,boolean[][]dp){
        if(sum == target){
            return true;
        }
        if(idx >= nums.length || sum > target)return false;
        if(dp[idx][sum]!=false){
            return dp[idx][target];
        }
        boolean notPick = subsetSum(target,nums,idx+1,sum,dp);
        boolean pick = subsetSum(target,nums,idx+1,sum+nums[idx],dp);
        return dp[idx][sum] = pick||notPick;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        int target = sum/2;
        if(sum % 2 != 0){
            return false;
        }
        boolean [][]dp = new boolean[n][target+1];
        for(boolean[]i : dp){
        Arrays.fill(i,false);
        }
        return subsetSum(target,nums,0,0,dp);
    }
}
