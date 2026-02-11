class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        int n = arr.length;
        int max = 0;
        int sum = 0;
         if (k > n) return -1;
        for(int i=0;i<n;i++){
            sum += arr[i];
            max = Math.max(max,arr[i]);
        }
        int low = max;
        int high = sum;
        int ans = 0;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(canPlace(mid,arr,k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    boolean canPlace(int maxP,int[]arr,int k){
        int currentPages = 0;
        int student = 1;
        for(int pages : arr){
            if(currentPages + pages > maxP){
                // the current student can not read these so we move to next student
                student++;
                currentPages = pages;
                // this because the pbook with arr[i] pages has to be given to someone right so the next students gets it
                if(student>k){
                    return false;
                }
            }else{
                currentPages += pages;
            }
        }
        return true;
    }
}
