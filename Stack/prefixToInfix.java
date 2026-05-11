// User function Template for Java

class Solution {
    static String preToInfix(String s) {
        // code here
        Stack<String> st = new Stack<>();
        for(int i=s.length()-1 ; i>=0;i--){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                st.push(c+"");
            }else{
                String a = st.pop();
                String b = st.pop();
                String str = "(" + a + c + b + ")";
                st.push(str);
            }
        }
        return st.pop();
    }
}
