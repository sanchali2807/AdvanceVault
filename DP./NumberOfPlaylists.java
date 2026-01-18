class Solution {
    public int numMusicPlaylists(int m, int n, int k) {
        long [][]dp = new long[n+1][m+1];//length and unique songs
        dp[0][0] = 1;
        int MOD = 1000000007;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=Math.min(i,m);j++){
                // if we want to add
                // used songs are j-1 and total is n so remaing is n-(j-1)
                dp[i][j] = dp[i-1][j-1] * (m-j+1) % MOD;
                // remaining songs so how mnay ways
                if(j>k){
                    dp[i][j] = (dp[i][j]+dp[i-1][j] * (j-k)) %MOD;
                }
            }
        }
        return (int)dp[n][m];
    }
}
