// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        boolean[]dp = new boolean[sum+1];
        dp[0] = true; // empty possible
        // if sum is s and one subset sum is x then other is s-x 
        //so s-x - x we get the differnwce 
        // so we can say that value is near sum/2
        for(int num :arr){
            for(int j = sum ; j>=num ;j--){
                dp[j] = dp[j] || dp[j-num];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<=sum/2;i++){
            if(dp[i]){
                ans = Math.min(ans,Math.abs(sum - 2*i));
            }
        }
        return ans;
        
    }
}
