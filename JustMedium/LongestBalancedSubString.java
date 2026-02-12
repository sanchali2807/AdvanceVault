class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int len = 0;
        for(int i=0;i<n;i++){
        int [] freq = new int[26];
            for(int j=i;j<n;j++){
                char c = s.charAt(j);
                freq[c - 'a']++;
                 int min = Integer.MAX_VALUE;
                int max = 0;
                for(int k=0;k<26;k++){
                    if (freq[k] > 0) {
                        min = Math.min(min, freq[k]);
                        max = Math.max(max, freq[k]);
                    }
                }
                if(max == min){
                    len = Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }

}
