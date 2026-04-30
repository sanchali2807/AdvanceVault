class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()){
            return;
        }
        int top = st.pop();
        reverseStack(st);
        insertAtBottom(st,top);
    }
    static void insertAtBottom(Stack<Integer> st,int top){
    if(st.isEmpty()){
        st.push(top);
        return;
    }
    int temp = st.pop();
    insertAtBottom(st,top);
    st.push(temp);
    }
}
