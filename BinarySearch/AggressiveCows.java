class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int low = 0;
        int high = stalls[stalls.length - 1];
        int ans = 0;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(canPlace(mid,stalls,k)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
            return ans;
    }
        boolean canPlace(int dis , int[]stall , int k){
            int count = 1;
            int lastPlaced = stall[0];
            for(int i=1;i<stall.length;i++){
                if(stall[i] - lastPlaced >= dis){
                    count++;
                    lastPlaced = stall[i];
                    if(count == k){
                        return true;
                    }
                }
            }
            return false;
        }
}
