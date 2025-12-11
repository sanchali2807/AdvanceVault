class Solution {
        int fun(int []dp,int idx, int [] cost){
        if(idx>=cost.length)return 0;
        if(dp[idx] != -1)return dp[idx];
        int oneStep = cost[idx] + fun(dp,idx+1,cost);
        int twoStep = cost[idx] + fun(dp,idx+2,cost);
        dp[idx] = Math.min(oneStep,twoStep);
        return dp[idx];
        }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int [n];
        Arrays.fill(dp,-1);
        return Math.min(fun(dp,0,cost),fun(dp,1,cost));
    }
}
