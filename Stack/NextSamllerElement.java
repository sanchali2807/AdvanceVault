class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        int[]res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i] <= st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<res.length;i++){
            list.add(res[i]);
        }
        return list;
    }
}
