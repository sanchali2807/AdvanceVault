class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int c = mat[0].length;
        int l = 0;
        int h = c-1;
        while(l<=h){
            int m = l + (h-l)/2;
            int maxR = 0;
            for(int i=0;i<n;i++){
                if(mat[i][m]>mat[maxR][m]){
                    maxR = i;
                }
            }
            int cur = mat[maxR][m];
            int left = (m-1 >= 0) ? mat[maxR][m - 1] : -1;
            int right = (m+1 < c) ? mat[maxR][m + 1] : -1;
            if(cur > left && cur > right){
                return new int[]{maxR,m};
            } else if(cur < left){
                    h = m - 1;
                }else{
                    l = m + 1;
                }
            }
        return new int[]{-1,-1};
        }
    }
