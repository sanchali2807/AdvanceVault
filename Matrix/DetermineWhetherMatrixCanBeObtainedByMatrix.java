class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        int[][]rotate = new int[n][m];
        while(count<4){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                rotate[i][j] = mat[j][m-i-1];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = rotate[i][j];
            }
        }
    boolean same = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( rotate[i][j] != target[i][j]){
                    same = false;
                    break;
                }
            }
        }
        if(same)return true;
        count++;
        }
        
        return false;
    }
}
