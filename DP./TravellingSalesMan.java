class Solution {
        int n ;
    public int tsp(int[][] cost) {
        // code here
        n = cost.length;
        int visited = 0;
        visited = (1<<n)-1;
        int[][]dp = new int[1<<n][n];
        for(int i=0;i<(1<<n);i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return solve(1,0,cost,dp,visited);
    }
    int solve(int mask , int city , int[][]cost,int[][]dp,int visited){
        if(mask == visited){
            return cost[city][0];
        }
        if(dp[mask][city]!=-1){
            return dp[mask][city];
        }
         int ans = Integer.MAX_VALUE;
        for(int next = 0 ; next<n;next++){
            if((mask & (1<<next) )== 0){
                int newMask = mask | (1<< next);
                int curr = cost[city][next] + solve(newMask,next,cost,dp,visited);
                ans = Math.min(curr,ans);
            }
        }
        return dp[mask][city] = ans;
    }
}
