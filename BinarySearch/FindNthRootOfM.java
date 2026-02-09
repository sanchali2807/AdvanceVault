class Solution {
    public int nthRoot(int n, int m) {
        // code here
         int i = 1;
         int j = m;
         if(n == 1)return m;
         if(m == 0)return 0;
         while(i<=j){
             int mid = i + (j - i)/2;
             if((int)(Math.pow(mid,n))==m){
                 return mid;
             }else if((int)(Math.pow(mid,n))>n){
                 j = mid - 1;
             }else{
                 i = mid + 1;
             
         }
         }
         return -1;
    }
}
