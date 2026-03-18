class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[]word = path.split("/");
        for(String s : word){
            if(s.equals("") || s.equals(".")) continue;
            if(s.equals("..")){
                if(!st.isEmpty()){
                st.pop();
                }
                }
                else st.push(s);
        }
        return "/"+String.join("/",st);
    }
}
