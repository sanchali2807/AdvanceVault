class Solution {
    int fun(int i,int[]arr){
        if(i==0)return 0;
        if(arr.length>1 && i==1)return Math.abs(arr[1] - arr[0]);
        return Math.min((Math.abs(arr[i]-arr[i-1])+fun(i-1,arr)),(Math.abs(arr[i]-arr[i-2])+fun(i-2,arr)));
    }
  int memo(int[] arr){
        int n = arr.length;
        if(n == 1) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);
        return memo_rec(n - 1, arr, dp);
    }

    int memo_rec(int i, int[] arr, int[] dp){

        if(i == 0) return 0;
        if(i == 1) return Math.abs(arr[1] - arr[0]);

        if(dp[i] != -1) return dp[i];

        int oneStep = Math.abs(arr[i] - arr[i-1]) + memo_rec(i-1, arr, dp);

        int twoStep = Math.abs(arr[i] - arr[i-2]) + memo_rec(i-2, arr, dp);

        return dp[i] = Math.min(oneStep, twoStep);
    }
    
    int minCost(int[] height) {
        // recursive function :: f(i) total min energy to reach 
        // n-1 from 0
        // f(i) = min([h(i) - h(i-1) + f(i-1)],[h(i) - h(i-2) + f(i-2)])
        return memo(height);
        // return fun(height.length-1,height);
    }
}
