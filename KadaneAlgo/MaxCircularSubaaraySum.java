class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
        int currMax = arr[0];
        int maxSum = arr[0];
        int currMin = arr[0];
        int minSum = arr[0];
        int total=arr[0];
        for(int i=1;i<arr.length;i++){
           total += arr[i];
        //   if(i>0)
            currMax = Math.max(arr[i],arr[i]+currMax);
            maxSum = Math.max(currMax,maxSum);
            currMin = Math.min(arr[i],arr[i]+currMin);
            minSum = Math.min(currMin,minSum);
        }
        if(maxSum<0)return maxSum;
        return Math.max(maxSum,total-minSum);
    }
}
