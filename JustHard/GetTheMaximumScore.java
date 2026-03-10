class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int mod = 1_000_000_007;
        int n = nums1.length;
        int m = nums2.length;
        long sum1 = 0;
        long sum2 = 0;
        int i = 0;
        int j = 0;
        long max = 0;
        while(i < n && j < m){
            if(nums1[i] == nums2[j]){
                sum1+=nums1[i];
                sum2+=nums2[j];
                max += Math.max(sum1,sum2);
                i++;
                j++;
                sum1 = 0;
                sum2 = 0;
            }else if(nums1[i] > nums2[j]){
                sum2+=nums2[j];
                j++;
            }else{
                sum1+=nums1[i];
                i++;
            }
        }
        while(i<n){
            sum1+=nums1[i];
            i++;
        }
        while(j<m){
            sum2+=nums2[j];
            j++;
        }
        max += Math.max(sum1,sum2);
        return (int)(max%mod);
    }
}
