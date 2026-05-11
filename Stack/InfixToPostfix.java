class Solution {
    static int precedence(char c){
        if(c == '^')return 3;
        if(c == '*' || c == '/')return 2;
        if(c == '-' || c == '+')return 1;
        return 0;
    }
    public static String infixToPostfix(String s) {
        // code here
        StringBuilder str = new StringBuilder();
        Stack<Character>st = new Stack<>();
        // s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i)))str.append(s.charAt(i));
            else if(s.charAt(i) == '(')st.push(s.charAt(i));
            else if(s.charAt(i) == ')'){
                while(!st.isEmpty() && st.peek()!= '('){
                    str.append(st.pop());
                }
                st.pop();
            }
            else{
          while(!st.isEmpty() && st.peek() != '(' && (precedence(s.charAt(i)) < precedence(st.peek()) ||
        (
            precedence(st.peek()) == precedence(s.charAt(i))
            && s.charAt(i
            ) != '^'
        ))){
              char c = st.pop();
              str.append(c);
          }
              st.push(s.charAt(i));  
            }
        }
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        return str.toString();
    }
}
