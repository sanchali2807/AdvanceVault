class Solution {
    String reverse(String s){
        StringBuilder str = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i) == '('){
                str.append(')');
            }else if(s.charAt(i) == ')'){
                str.append('(');
            }else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
    int precedence(char c){
        if(c == '^')return 3;
        if(c == '*' || c == '/')return 2;
        if(c == '+' || c == '-')return 1;
        return 0;
    }
    public String infixToPrefix(String s) {
        // code here
        String str = reverse(s);
        Stack<Character> st = new Stack<>();
        StringBuilder newStr = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = str.charAt(i);
            if(Character.isLetterOrDigit(c))newStr.append(c);
            else if(c == '(')st.push(c);
            else if(c == ')'){
                while(!st.isEmpty() && st.peek()!='('){
                    newStr.append(st.pop());
                }
                st.pop();
            }
            else{
            while(!st.isEmpty() && st.peek()!='('
            && (precedence(c) < precedence(st.peek()) || 
            (precedence(c) == precedence(st.peek()) && c == '^'))){
                newStr.append(st.pop());
            }
        st.push(c);
        }
    }
    while(!st.isEmpty()){
        newStr.append(st.pop());
    }
        return reverse(newStr.toString());
}
    
}
