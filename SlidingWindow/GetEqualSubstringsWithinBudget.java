class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0;
        int r = 0 ;
        int n = s.length();
        int m = t.length();
        int count = 0;
        int val = 0;
        while(r<n){
            val += Math.abs(t.charAt(r) - s.charAt(r));
            while(val > maxCost){
                val -= Math.abs(t.charAt(l) - s.charAt(l));
                l++;
            }
            count = Math.max(r-l+1,count);
            r++;
        }
        return count;
    }
}
