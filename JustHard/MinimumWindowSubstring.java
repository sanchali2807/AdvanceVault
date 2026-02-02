class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        for(int i=0;i<t.length();i++){
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        Map<Character,Integer> window = new HashMap<>();
        int minSize = Integer.MAX_VALUE;
        int valid = 0;
        int l = 0;
        int r = 0;
        int st = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            if(need.containsKey(c)){
            window.put(c,window.getOrDefault(c,0)+1);
            if(window.get(c).equals(need.get(c))){
                valid++;
            }
            }
            while(valid == need.size()){
               if(r - l + 1 < minSize){
            minSize = r - l + 1;
            st = l;
            }
                char d = s.charAt(l);
               if(need.containsKey(d)){
    if(window.get(d).intValue() == need.get(d).intValue()) valid--;
    window.put(d, window.get(d) - 1);
}

                l++;
            }
            r++;
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(st, st + minSize);
    }
}
