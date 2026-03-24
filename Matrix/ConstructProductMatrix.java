class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;
        int[]flat = new int[n*m];
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                flat[idx++] = grid[i][j];
            }
        }
        int[]res = new int[n*m];
        int r = 1;
        int l = 1;
        for(int i=0;i<n*m;i++){
            res[i] = l;
             l = (int)((1L * l * flat[i]) % mod);
            // res[i] = res[i-1] * flat[i-1];
        }
        for(int i=n*m-1;i>=0;i--){
            res[i] = (res[i] * r)%mod;
            r = (int)((1L * r * flat[i]) % mod);
        }
        for(int i=0;i<n*m;i++){
            grid[i/m][i%m] = res[i];
        }
        return grid;
    }
}
