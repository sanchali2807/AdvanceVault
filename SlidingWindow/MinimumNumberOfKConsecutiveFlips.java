class Solution {
    public int minKBitFlips(int[] nums, int k) {

        int n = nums.length;
        int flips = 0;
        int ans = 0;
        int[]isFlipped = new int[n];
       for(int i=0;i<n;i++){
        if(i >=k ){ // why i >= k because we need to check outside the window so i-k index will be checked for the ans and if k is at a index where i may become negative so we do not check
            flips = flips - isFlipped[i-k];
        }
        if((nums[i] == 1 && flips % 2 == 1) || (nums[i] == 0 && flips % 2 == 0)){
            if(i + k > n)return -1; // it means we are in the need to flip but we cannot as the window is out of scope
            flips++;
            ans++;
            isFlipped[i] = 1;
            // it means somethings was flipped here 
        }
       }
        return ans;
    }
}
