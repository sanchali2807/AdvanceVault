class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][]matrix = new int[n][m];
        int top = x;
        int bottom = x+k-1;
        while(top<bottom){
          int left = y;
          int right = y + (k-1);
            while(left<=right){
                int temp = grid[top][left];
                grid[top][left] = grid[bottom][left];
                grid[bottom][left] = temp;
                left++;
            }
            top++;
            bottom--;
        }
    } 
}
