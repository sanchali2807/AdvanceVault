class Solution {
    public int captureForts(int[] forts) {
        int max = 0;
        int n = forts.length;
        for(int i=0;i<n;i++){
            if(forts[i] == 1){
                int count = 0;
                int j = i+1;
                while(j<n && forts[j] == 0){
                    count++;
                    j++;
                }
                if(j<n && forts[j]==-1){
                    max = Math.max(max,count);
                }
            }
        }
        for(int i = n-1;i>=0;i--){
            if(forts[i] == 1){
                int count = 0;
                int j = i-1;
                while(j>=0 && forts[j] == 0){
                    count++;
                    j--;
                }
                if(j>=0 && forts[j]==-1){
                    max = Math.max(max,count);
                }
            }
        }
        return max;
    }
}
