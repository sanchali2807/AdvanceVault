class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        int n = s.length();
        for(char c : s.toCharArray()){
            int len = str.length();
            if(len>=2 && c == str.charAt(len-1) && c == str.charAt(len-2)){
                continue;
            }
            str.append(c);
        }
        return str.toString();
    }
}
