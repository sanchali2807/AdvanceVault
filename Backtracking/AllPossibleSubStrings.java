// User function Template for Java

class Solution {
    public List<String> AllPossibleStrings(String s) {
        // Code here
        List<String> str = new ArrayList<>();
        StringBuilder a = new StringBuilder();
        fun(s,str,0,s.length(),a);
        Collections.sort(str);
        return str;
    }
    void fun(String s,List<String>str,int idx ,int n , StringBuilder a){
        str.add(new String(a.toString()));
        for(int i=idx;i<n;i++){
            a.append(s.charAt(i));
            fun(s,str,i+1,n,a);
            a.deleteCharAt(a.length()-1);
        }
    }
}
