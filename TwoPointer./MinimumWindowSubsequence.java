class Solution {
    public String minWindow(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int i = 0;
        int j = 0;
        int start = -1;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        while(i<n){
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
            if(j == m){
                end = i;
                j = m-1;
                
                while(i>= 0){
                    if(s1.charAt(i) == s2.charAt(j)){
                        j--;
                        if(j<0)break;
                    }
                    i--;
                }
                int startIdx = i;
                int len = end - startIdx + 1;
                if(len < minLen){
                    minLen = len;
                    start = startIdx;
                }
                i = startIdx+1;
                j = 0;
            }
            }
            i++;
        }
        return start == -1. ?"":s1.substring(start,start+minLen);
    }
}
