class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[]res = new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i%n] >= st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                res[i%n] = -1;
            }else{
                res[i%n] = st.peek();
            }
            st.push(arr[i%n]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(res[i]);
        }
        return list;
    }
}
