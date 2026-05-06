class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int res = 0;
        for(int i=0;i<n;i++){
            Map<Integer,Integer>mp = new HashMap<>();
            for(int j=0;j<n;j++){
                if(i == j)continue;
                int dx1 = points[i][0] - points[j][0];
                int dx2 = points[i][1] - points[i][1];

                int dis = dx1 * dx1 + dx2 * dx2;
                mp.put(dis,mp.getOrDefault(dis,0)+1);
            }
            for(int value : mp.values()){
                res += value * (value - 1);
                // n!
            }
        }
        return res;
    }
}
