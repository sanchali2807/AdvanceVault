class Solution {
    int fun(int i,int[]arr){
        if(i==0)return 0;
        if(arr.length>1 && i==1)return Math.abs(arr[1] - arr[0]);
      // recursive
        return Math.min((Math.abs(arr[i]-arr[i-1])+fun(i-1,arr)),(Math.abs(arr[i]-arr[i-2])+fun(i-2,arr)));
    }
    int minCost(int[] height) {
        // recursive function :: f(i) total min energy to reach 
        // n-1 from 0
        // f(i) = min([h(i) - h(i-1) + f(i-1)],[h(i) - h(i-2) + f(i-2)])
        
        return fun(height.length-1,height);
    }
}
