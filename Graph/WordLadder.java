class Solution {
    class pair{
        String str;
        int d;
        pair(String str,int d){
            this.str = str;
            this.d = d;
        }
    }
    public int wordLadderLength(String startWord, String targetWord,
                                String[] wordList) {
         Queue<pair> q = new LinkedList<>();
         q.add(new pair(startWord,1));
         Set<String>st = new HashSet<>();
         for(int i=0;i<wordList.length;i++){
             st.add(wordList[i]);
         }
         while(!q.isEmpty()){
             pair p = q.poll();
             String str = p.str;
             int dis = p.d;
             if(str.equals(targetWord)){
                 return dis;
             }
             for(int i=0;i<str.length();i++){
                 for(char ch = 'a';ch<='z';ch++){
                     char[]word = str.toCharArray();
                     word[i] = ch;
                     String replaceWord = new String(word);
                     if(st.contains(replaceWord)){
                         st.remove(replaceWord);
                         q.add(new pair(replaceWord,dis+1));
                     }
                 }
             }
         }
        return 0;
    }
}
