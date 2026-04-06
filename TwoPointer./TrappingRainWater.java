class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0 ;
        int right = n-1 ; 
        int leftmax = height[0] ;
        int rightmax = height[n-1] ;
        int total = 0 ;
        while(left <= right){
            if(leftmax < rightmax){
                if(height[left] < leftmax){
                    total = total + leftmax - height[left];
                }else{
                    leftmax = height[left];
                }
                left++;
            }else{
                if(height[right] < rightmax){
                    total = total + rightmax - height[right];
                }else{
                    rightmax = height[right];
                }
                right--;
            }
        }
        return total;
    }
}
