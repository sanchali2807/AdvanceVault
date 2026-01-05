// User function Template for Java

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String beginWord, String endWord,
                                                      String[] wordList) {
        // Code here
         Set<String> st = new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            st.add(wordList[i]);
        }
        Queue<ArrayList<String>>q = new LinkedList<>();
        ArrayList<String>list = new ArrayList<>();
        list.add(beginWord);
        q.add(list);
        List<String>used = new ArrayList<>();
        used.add(beginWord);
        int level = 0;
        ArrayList<ArrayList<String>>ans = new ArrayList<>();
        while(!q.isEmpty()){
            ArrayList<String>l = q.poll();
            if(l.size()>level){
                level++;
                for(String i : used){
                    st.remove(i);
                }
            }
            String word = l.get(l.size()-1);
            if(word.equals(endWord)){
                // if(ans.size()==0){
                ans.add(l);
                // }else if()
            }
            for(int i=0;i<word.length();i++){
                String original = word;
                for(char ch ='a';ch<='z';ch++){
                    char[]words = word.toCharArray();
                    words[i] = ch;
                    String replacedword = new String (words);
                    if(st.contains(replacedword)){
                        ArrayList<String> newList = new ArrayList<>(l);
                        newList.add(replacedword);
                        q.add(newList);
                        used.add(replacedword);
                        // l.remove(l.size()-1);
                    }
                  
                }
            }
        }
        return ans;
    }
}
