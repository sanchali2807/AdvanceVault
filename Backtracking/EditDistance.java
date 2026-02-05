class Solution {
    public int fun(String word,int j , String target,int i,int[][]dp){
        if(j == word.length()){
            return target.length() - i;
        }
        if(i == target.length()){
            return word.length() - j;
        }
        if(dp[j][i] != -1){
            return dp[j][i];
        }
        if(word.charAt(j) == target.charAt(i)){
            return dp[j][i] = fun(word, j + 1, target, i + 1, dp);
        }

        int insert = 1 + fun(word,j,target,i+1,dp);
        int delete = 1 + fun(word,j+1,target,i,dp);
        int replace = 1 + fun(word,j+1,target,i+1,dp);
        dp[j][i] =  Math.min(insert,Math.min(delete,replace));
    return dp[j][i];
        }
    
    public int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            for(int j=0;j<=word2.length();j++){
                dp[i][j] = -1;
            }
        }
        int count = fun(word1,0,word2,0,dp);
        return count;
    }
}
