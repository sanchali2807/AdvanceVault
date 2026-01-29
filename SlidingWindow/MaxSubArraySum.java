class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int r = 0;
        int l = 0;
        int sum = 0;
        int max = 0;
        while(r<n){
            sum += arr[r];
            if(r-l+1 == k){
                max = Math.max(max,sum);
                sum = sum - arr[l];
                l++;
            }
            
            r++;
        }
        return max;
    }
}
