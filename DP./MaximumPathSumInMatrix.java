// User function Template for Java
class Solution {
    public int fun(int[][]a , int r,int c,int i, int j,int[][]dp){
        if(j<0)return 0;
        if(i>=r || j>=c)return 0;
        if(i==r-1)return a[i][j];
        if(dp[i][j]!=-1)return dp[i][j];
        int down = fun(a,r,c,i+1,j,dp);
        int dLeft = fun(a,r,c,i+1,j-1,dp);
        int dRight = fun(a,r,c,i+1,j+1,dp);
        return dp[i][j]= Math.max(down,Math.max(dLeft,dRight))+a[i][j];
    }
    public int maximumPath(int[][] mat) {
      int n = mat.length;
      int m = mat[0].length;
      int[][] dp = new int[n][m];
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              dp[i][j]=-1;
          }
      }
      int ans = 0;
      for(int i=0;i<m;i++){
       ans = Math.max(ans, fun(mat, n, m, 0, i,dp));
      }
        return ans;
    }
}
