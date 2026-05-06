class Solution {
    public int numberOfBoomerangs(int[][] points) {
       int n = points.length ;
       if(n<=2)return 0;
       int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k = 0;k<n;k++){
                    if(i==j || i == k || j == k )continue;
                    int dx1 = points[i][0] - points[k][0];
                    int dx2 = points[i][1] - points[k][1];
                    int dx3 = points[i][0] - points[j][0];
                    int dx4 = points[i][1] - points[j][1];
                    int dis1 = dx1 * dx1 + dx2 * dx2;
                    int dis2 = dx3 * dx3 + dx4 * dx4;
                    if(dis1 == dis2){
                        count++;
                    }
                }
            }
        }
       return count;

    }
}
