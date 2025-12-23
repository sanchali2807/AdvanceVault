class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        fun(0,s,list,res);
        return res;
    }
    public void fun(int st,String s,List<String>list,List<List<String>> res){
        if(st == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=st;i<s.length();i++){
            if(isPalindrom(st,i,s)){
                list.add(s.substring(st,i+1));
                fun(i+1,s,list,res);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrom(int s,int e,String st){
        if(s>e){
            return false;
        }
        while(s<e){
            if(st.charAt(s)!=st.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
