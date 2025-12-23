class Solution {
     String[] mp = {
    "", "", "abc", "def", "ghi",
    "jkl", "mno", "pqrs", "tuv", "wxyz"
};
public void fun(int i,String s,List<String>res,StringBuilder ans){
    if(i==s.length()){
        res.add(ans.toString());
        return;
    }
    int d = s.charAt(i) - '0';
    String temp = mp[d];
    for(char c : temp.toCharArray()){
        ans.append(c);
        fun(i+1,s,res,ans);
        ans.deleteCharAt(ans.length()-1);
    }
}
    public List<String> letterCombinations(String digits) {
        StringBuilder ans = new StringBuilder();
        List<String> list = new ArrayList<>();
        fun(0,digits,list,ans);
        return list;
    }
}
