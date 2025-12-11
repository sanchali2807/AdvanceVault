class Solution {
    public int fun(int i,int j,int r,int c,int[][]dp){
        if(i==r-1 && j== c-1){
            return 1;
        }
        if (i >= r || j >= c) return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int p = fun(i,j+1,r,c,dp);
        int p1 = fun(i+1,j,r,c,dp);
        return dp[i][j] = p+p1;
    }
    public int numberOfPaths(int m, int n) {
        int[][]dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return fun(0,0,m,n,dp);
     
    }
}
