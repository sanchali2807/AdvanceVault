// User function Template for Java

class Solution {
    static ArrayList<Integer> maxSum(int[] arr, int k) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        int sum = 0;
        int max = 0;
        int bestdiff = 0;
        
        int i = -1;
        int j = -1;
        while(l<r){
            sum = arr[r] + arr[l];
            if(sum >= k){
                r--;
            }else{
                int diff = Math.abs(arr[r]-arr[l]);
                if(sum > max || (sum == max && diff > bestdiff)){
                    max = sum;
                    bestdiff = diff;
                    i = arr[l];
                    j = arr[r];
                }
                    l++;
            }
        }
            if(max!=-1){
                res.add(i);
                res.add(j);
            }
        return res;
    }
}
