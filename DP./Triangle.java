class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            int a = triangle.get(i).size();
            for(int j=0;j<a;j++){
                int val = triangle.get(i).get(j);
                if(j==0){
                    dp[i][j] = val + dp[i-1][j];
                }else if(j == a-1){
                    dp[i][j] = val + dp[i-1][j-1];
                }else{
                dp[i][j] = val + Math.min(dp[i-1][j-1] , dp[i-1][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(n-1).size();i++){
            ans = Math.min(dp[n-1][i],ans);
        }
        return ans;
    }
}
