class Solution {
    int[] prevMin(int nums[]){
        int n = nums.length;
        int [] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
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
    int[] prevMax(int nums[]){
        int n = nums.length;
        int [] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
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
    int[] nextMax(int nums[]){
        int n = nums.length;
        int [] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = n;
            }else{
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
    int[] nextMin(int nums[]){
        int n = nums.length;
        int [] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = n;
            }else{
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public long subArrayRanges(int[] nums) {
        int [] pse = prevMin(nums);
        int [] nse = nextMin(nums);
        int [] pge = prevMax(nums);
        int [] nge = nextMax(nums);
        // max
        long max = 0 ;
        long min = 0;
        for(int i=0;i<nums.length;i++){
            int left = i - pge[i];
            int right = nge[i] - i;
            max += (long) left * right * nums[i];
        }
        for(int i=0;i<nums.length;i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            min += (long) left * right * nums[i];
        }
        return max - min;
    }
}
