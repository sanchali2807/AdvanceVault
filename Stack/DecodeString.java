class Solution {
    class Pair{
        String curr ; 
        int count;
        Pair(String curr,int count){
            this.curr = curr;
            this.count = count;
        }
    }
    public String decodeString(String s) {
        Stack<Pair> st = new Stack<>();
            StringBuilder curr = new StringBuilder();
            int count = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                 count = count * 10 + (c - '0');
            }
            else if(c == '['){
                st.push(new Pair(curr.toString(),count));
                curr = new StringBuilder();
                count = 0;
            }
            else if(c == ']'){
                Pair val = st.pop();
                StringBuilder temp = new StringBuilder(val.curr);
                for(int j=1;j<=val.count;j++){
                    temp.append(curr);
                }
                curr = temp;
            }else{
                 curr.append(c);
            }
        }
        return curr.toString();
    }
}
