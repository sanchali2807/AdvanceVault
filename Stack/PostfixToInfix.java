// User function Template for Java

class Solution {
    static String postToInfix(String s) {
        // code here
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                st.push(c+"");
            }else{
                String b = st.pop();
                String a = st.pop();
                st.push("(" + a + c + b +")");
            }
        }
        return st.pop();
    }
}
