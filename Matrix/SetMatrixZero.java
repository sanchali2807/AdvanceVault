class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int []row = new int [r];
        int []col = new int [c];
        int indexr = 0;
        int indexc = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == 0){
                    row[i] = 2;
                    col[j] = 2;
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(row[i] == 2 || col[j] == 2 ){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
