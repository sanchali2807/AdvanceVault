class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        Set<Character>hs = new HashSet<>();
        int n = s.length();
        int r = 0;
        int l = 0;
        int len = 0;
        int max = 0;
        while(r<n){
            while(hs.contains(s.charAt(r))){
                // len = r-l+1;
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(r));
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}
