class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[]dp = new int[n];
        Arrays.fill(dp,-1);
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,dfs(i,d,arr,dp));
        }
        return ans;
    }
    int dfs(int i,int d ,int [] arr,int []dp){
        int n = arr.length;
        int best = 1;
        if(dp[i] != -1)return dp[i];
        // check right
        for(int j=i+1;j<=Math.min(n-1,i+d);j++){
            if(arr[j] < arr[i]){
              best = Math.max(best,1 + dfs(j,d,arr,dp));
            }else{
                break;
            }
        }
        // check left
        for(int j = i-1 ; j>= Math.max(0,i-d);j--){
            if(arr[j] < arr[i]){
                best = Math.max(best,1+dfs(j,d,arr,dp));
            }else{
                break;
            }
        }
        return dp[i] = best;
    }
}
