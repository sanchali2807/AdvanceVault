class Solution {
    int [] previousSmaller(int[]arr){
        int[]res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
     int [] nextSmaller(int[]arr){
        int[]res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = arr.length;
            }else{
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
         int mod = 1000000007;
        int []pse = previousSmaller(arr);
        int []nse = nextSmaller(arr);
        for(int i=0;i<n;i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            sum = (sum + (long)left * arr[i] * right)%mod;
        }
        return (int)sum;
    }
}
