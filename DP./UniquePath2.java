class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        if(mat[0][0] == 1 || mat[n-1][m-1] == 1)return 0;
        int [][] dp = new int[n][m];
        dp[0][0]=1;
        for(int i=1;i<n;i++){
            if(mat[i][0] == 0){
                dp[i][0] = dp[i-1][0];
            }
        }
        for(int i=1;i<m;i++){
            if(mat[0][i] == 0){
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
