class Solution {
    public int[] asteroidCollision(int[] a) {
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            boolean destroyed = false;
            while(!st.isEmpty() && st.peek() > 0 && a[i] < 0){
                if(st.peek() < Math.abs(a[i])){
                    st.pop();
                }else if(st.peek() == Math.abs(a[i])){
                    st.pop();
                    destroyed = true;
                    break;
                }else{
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                st.push(a[i]);
            }
        }
        int[]arr = new int[st.size()];
        for(int i = st.size()-1;i>=0;i--){
            arr[i] = st.pop();
        }
        return arr;

    }
}
