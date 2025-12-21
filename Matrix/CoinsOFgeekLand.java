class Solution {
    public int Maximum_Sum(int mat[][], int n, int k) {
       int[][]prefix = new int[n][n];
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               prefix[i][j] = mat[i][j];
               if(i>0) prefix[i][j] += prefix[i-1][j];
               if(j>0) prefix[i][j] += prefix[i][j-1];
               if(i>0 && j>0) prefix[i][j] -= prefix[i-1][j-1];
           }
       }
       int max = Integer.MIN_VALUE;;
       for(int i=0;i<n-k+1;i++){
           for(int j=0;j<n-k+1;j++){
               int sum = prefix[i+k-1][j+k-1];
               if(i>0) sum -= prefix[i-1][j+k-1];
               if(j>0) sum-= prefix[i+k-1][j-1];
               if(i>0 && j>0) sum+= prefix[i-1][j-1];
               max=Math.max(sum,max);
           }
       }
       return max;
    }
}
