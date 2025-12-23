class Solution {
    public void dfs(int[][]image,int []dr,int[]dc,int r,int c,int inicolor,int color){
        int n = image.length;
        int m = image[0].length;
        image[r][c] = color;
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc]==inicolor && image[nr][nc] != color){
                dfs(image,dr,dc,nr,nc,inicolor,color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int []dr = {-1,1,0,0};
        int []dc = {0,0,-1,1};
        int n = image.length;
        int m = image[0].length;
        int inicolor = image[sr][sc];
        if (inicolor == color) return image;
        dfs(image,dr,dc,sr,sc,inicolor,color);
        return image;
    }
}
