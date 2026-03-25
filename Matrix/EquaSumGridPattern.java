class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long total = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                total += grid[i][j];
            }
        }
        long sumC1 = 0;
        long sumR1 = 0;
        //vertical cut
        for(int c = 0 ; c < m - 1 ; c++){
            for(int r = 0; r < n; r++){
                sumC1 += grid[r][c];
            }
            long sum2 = total - sumC1;
            if(sum2 == sumC1){
                return true;
            }
        }
        // horizontal cut
        for(int r = 0 ; r < n - 1 ; r++){
            for(int c = 0 ; c < m ; c++){
                sumR1 += grid[r][c];
            }
            long sum2 = total - sumR1;
            if(sumR1 == sum2){
                return true;
            }
        }
        return false;
    }
}
