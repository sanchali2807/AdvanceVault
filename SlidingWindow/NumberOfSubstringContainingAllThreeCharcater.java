class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int [] freq = new int[26];
        int res = 0;
        while(r<n){
            freq[s.charAt(r) - 'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2] > 0){
                res += n-r;
                freq[s.charAt(l)-'a']--;
                l++;
            }
            r++;
        }
        return res;
    }
}
