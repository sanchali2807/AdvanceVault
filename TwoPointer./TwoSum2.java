class Solution {
    public int[] twoSum(int[] num, int target) {
        int n = num.length;
        int l = 0;
        int r = n-1;
        while(l<r){
            if(num[l] + num[r] == target){
                return new int[]{l+1,r+1};
            }else if(num[l] + num[r] > target){
                r--;
            }else{
                l++;
            }
        }
        return new int[]{-1,-1};
    }
}
