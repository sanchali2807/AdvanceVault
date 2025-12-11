class Solution {
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int[]dp = new int[n+1];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]); 
        for(int i=2;i<n;i++){
            int skip = dp[i-1];
            int loot = arr[i] + dp[i-2];
            dp[i] = Math.max(loot,skip);
        }
        return Math.max(dp[n-2],dp[n-1]);
    }
    
}
