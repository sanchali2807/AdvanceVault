class Solution {
    void fun(Stack<Integer> st,int top){
        if(st.isEmpty()||st.peek() <= top){
            st.push(top);
            return;
        }
        int temp = st.pop();
        fun(st,top);
        st.push(temp);
    }
    public void sortStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty())return;
        int top = st.pop();
        sortStack(st);
        fun(st,top);
    }
}
