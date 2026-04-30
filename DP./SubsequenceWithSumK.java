class Solution {
    static boolean helper(int[]arr,int sum,int val,int idx,Boolean[][]dp){
        if(val == sum)return true;
        if(val > sum){
            return false;
        }
        if(idx == arr.length)return false;
        if(dp[idx][val] != null)return dp[idx][val];
        //pick and not pick
        boolean pick = helper(arr,sum,val+arr[idx],idx+1,dp);
        boolean notPick = helper(arr,sum,val,idx+1,dp);
        return dp[idx][val] = pick || notPick;
        
    }
    public boolean checkSubsequenceSum(int[] arr, int k) {
        // code here
        Boolean [][]dp = new Boolean[arr.length][k+1];
        return(helper(arr,k,0,0,dp));
    }
}
