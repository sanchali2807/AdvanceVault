class Solution {
    static String preToPost(String s) {
        // code here
        Stack<String>st = new Stack<>();
        for(int i= s.length()-1 ; i >= 0 ;i--){
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                st.push(c+"");
            }else{
                String str="";
                String a = st.pop();
                String b = st.pop();
                 str = str + a + b + c;
                st.push(str);
            }
        }
        return st.pop();
    }
}
