class Solution {
    public int evalRPN(String[] target) {
        Stack<String> st = new Stack<>();
        int result = 0;
        for(int i=0;i<target.length;i++){
            if(!target[i].equals("+") && !target[i].equals("-") && !target[i].equals("*") && !target[i].equals("/")){
                st.push(target[i]);
            }else{
                if(st.size() > 1){
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                if(target[i].equals("+")){
                    result = a+ b;
                }else if (target[i].equals("-")){
                    result = b - a;
                }else if(target[i].equals("*")){
                    result = a * b;
                }else if(target[i].equals("/")){
                    result = b/a;
                }
                st.push(String.valueOf(result));
                }
            }
        }
        return Integer.parseInt(st.peek());
    }
}
