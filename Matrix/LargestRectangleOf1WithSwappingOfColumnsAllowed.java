// User function Template for Java

class Solution {
    int maxArea(boolean[][] mat, int r, int c) {
        int height[] = new int[c];
        int ans = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(mat[i][j]==true){
                    height[j]++;
                }else{
                    height[j]=0;
                }
            }
            int[] temp = height.clone();
            Arrays.sort(temp);
            for(int k = c - 1; k >= 0; k--){
                int max = temp[k]*(c-k);
            ans = Math.max(max,ans);
            }
        }
        
        return ans; 
    }
}
