class Solution {
    public static int countSubstring(String s) {
        // code here
        int[]freq = new int[3];
        int n = s.length();
        int l = 0;
        int r = 0;
        int valid = 0;
        int count =0;
        while(r<n){
            char c = s.charAt(r);
            freq[c-'a']++;
            if(freq[c-'a'] == 1){
                valid++;
            }
            while(valid == 3){
                count+=n-r;
                // because if till r it is valid then after r it is also valid so we can move l now
                int idx = s.charAt(l) - 'a';
                freq[idx]--;
                if(freq[idx] == 0){
                    valid--;
                }
                l++;
            }
            r++;
        }
        return count;
    }
}
