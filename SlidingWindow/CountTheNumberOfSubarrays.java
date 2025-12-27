// User function Template for Java
class Solution {
    long countSubarray(int N, int a[], long L, long R) {
        // code here
        return fun(N,a,R) - fun(N,a,L-1);
    }
    long fun(int n,int[]a,long x){
        long sum = 0;
        long count=0;
        int l = 0;
        for(int r=0;r<n;r++){
            sum += a[r];
            while(sum>x){
                sum = sum-a[l];
                l++;
            }
            count += r-l+1;
        }
        return count;
    }
    
}
