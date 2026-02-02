class Solution {
    public String extend(String s , int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            r++;
            l--;
        }
        return s.substring(l+1,r);
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        String max = " ";
        for(int i=0;i<n;i++){
            String odd = extend(s,i,i);
            String even = extend(s,i,i+1);
            if(even.length() > max.length()){
                max = even;
            }
            if(odd.length() > max.length()){
                max = odd;
            }
        }
        return max;
    }
}
