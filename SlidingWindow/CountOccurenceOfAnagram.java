// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        Map<Character,Integer> mp = new HashMap<>();
        Map<Character,Integer> mp1 = new HashMap<>();
        int count = 0;
        for(char c : pat.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        int n = txt.length();
        int r = 0;
        int l = 0;
        int k = pat.length();
        while(r<n){
                mp1.put(txt.charAt(r),mp1.getOrDefault(txt.charAt(r),0)+1);
            if(r-l+1 > k){
                int f = mp1.get(txt.charAt(l))-1;
                if(f == 0){
                    mp1.remove(txt.charAt(l));
                }else{
                mp1.put(txt.charAt(l),f);
                    
                }
                l++;
            }
            if(r-l+1 == k){
                if(mp.equals(mp1)){
                    count++;
                }
            }
                r++;
        }
        return count;
    }
}
