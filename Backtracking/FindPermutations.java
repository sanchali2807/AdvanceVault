class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        ArrayList<String> list = new ArrayList<>();
        boolean[]visit = new boolean[s.length()];
        StringBuilder str = new StringBuilder();
        fun(s,list,visit,s.length(),str);
        Collections.sort(list);
        Set<String> st = new TreeSet<>();
        for(String i:list){
            st.add(i);
        }
        return new ArrayList<>(st);
    }
    void fun(String s,ArrayList<String> list, boolean[]visit,int n,StringBuilder str ){
        if(str.length() == n){
            list.add(new String(str.toString()));
            return;
        }
        for(int i=0;i<n;i++){
            if(visit[i]){
                continue;
            }
            visit[i]=true;
            str.append(s.charAt(i));
            fun(s,list,visit,n,str);
            str.deleteCharAt(str.length()-1);
            visit[i] = false;
        }
    }
}
