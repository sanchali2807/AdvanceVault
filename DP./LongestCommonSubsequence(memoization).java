class Solution {
    public int LCS(int[][]dp , int i ,int j , String s1 , String s2){
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
           dp[i][j] =  1 + LCS(dp,i+1,j+1,s1,s2);
        }else{
            dp[i][j] =  Math.max(LCS(dp,i+1,j,s1,s2),LCS(dp,i,j+1,s1,s2));
        }
        return dp[i][j];
    }
    public int longestCommonSubsequence(String t1, String t2) {
        int n = t1.length();
        int m = t2.length();
        int [][] dp = new int[n][m];
        for(int[]i:dp){
            Arrays.fill(i,-1);
        }
        return LCS(dp,0,0,t1,t2);

    }
}
