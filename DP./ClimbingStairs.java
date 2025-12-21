class Solution {
    public int climbStairs(int n) {
        int []dp = new int[n+1];
        dp[0] = 1;//on the ground
        dp[1] = 1;// first step
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
