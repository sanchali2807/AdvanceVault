class Solution {
    int dfs(int idx,int n,int []nums,int target,int[]dp){
        if(idx == n-1)return 0; // no jumps
        // if(idx >= n)return Integer.MAX_VALUE;
        if(dp[idx] != -1)return dp[idx];
        int maxJumps = Integer.MIN_VALUE;
        for(int i = idx+1;i<n;i++){
            if(Math.abs(nums[idx] - nums[i]) <= target){
               maxJumps = Math.max(maxJumps , 1 + dfs(i,n,nums,target,dp));
            }
        }
        return dp[idx] = maxJumps;
    }
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        int ans =  dfs(0,n,nums,target,dp);
        return ans < 0 ? -1 : ans;
    }
}
