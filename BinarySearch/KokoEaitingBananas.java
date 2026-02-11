class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int n = piles.length;
        for(int i=0;i<n;i++){
            max = Math.max(piles[i],max);
        }
        int low = 1;
        int high = max;
        int ans = 0;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(canPlace(mid,piles,h)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    boolean canPlace(int d,int[]piles,int h){
        int sum = 0;
        for(int i=0;i<piles.length;i++){
            sum += (piles[i] + d - 1)/d;
            if(sum > h){
                return false;
            }
        }
        return true;
    }
}
