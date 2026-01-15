class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length][amount+1];
        for(int i=0;i<amount+1;i++){
            if(i % coins[0] == 0){
                dp[0][i] = i / coins[0];
            }else{
                dp[0][i] = (int)(1e9);
            }
        }
        for(int i=1;i<coins.length;i++){
            for(int j=0;j<amount+1;j++){
                int pick = (int)(1e9);
                if(j >= coins[i]){
                    pick = 1 + dp[i][j-coins[i]];
                }
                int noPick = dp[i-1][j];
                dp[i][j] = Math.min(pick,noPick);
            }
        }
        if(dp[coins.length-1][amount] == (int)(1e9)){
            return -1;
        }else{
            return dp[coins.length-1][amount];
        }
    }
}
