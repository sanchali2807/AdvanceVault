class Solution {
    static class pair{
        int h ;
        int w ;
        int d ;
        pair(int h,int w,int d){
            this.h=h;
            this.w=w;
            this.d=d;
        }
        
    }
    public static int maxHeight(int[] height, int[] width, int[] length) {
        // Code here
        int n = height.length;
        pair[] box = new pair[3*n];
        int index = 0;
        for(int i=0;i<n;i++){
            int h = length[i];
            int w = width[i];
            int d = height[i];
            box[index++] = new pair(h, Math.max(w, d), Math.min(w, d));
            box[index++] = new pair(w, Math.max(h, d), Math.min(h, d));
            box[index++] = new pair(d, Math.max(h, w), Math.min(h, w));
        }
        int m = index;
        Arrays.sort(box,(a,b) -> (b.w * b.d - a.w * a.d));
        int []dp = new int[m];
        for(int i=0;i<m;i++){
            dp[i] = box[i].h;
        }
            for(int i=1;i<m;i++){
                for(int j=0;j<i;j++){
                    if(box[i].w < box[j].w && box[i].d < box[j].d){
                        dp[i] = Math.max(dp[i] , dp[j] + box[i].h);
                    }
                }
            
        }
        int max = 0;
        for(int i=0;i<m;i++){
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
