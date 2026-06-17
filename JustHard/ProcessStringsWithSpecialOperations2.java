class Solution {
    public char processStr(String s, long k) {
        StringBuilder str = new StringBuilder();
        long [] len = new long[s.length()];
        long L = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '#'){
                L = L*2;
            }
            else if ( c == '%' ){
            }
            else if( c == '*' ){
                if(L > 0){
                    L--;
                }
            }else{
                L++;
            }
            len[i] = L;
            
        }
        if(k >= L)return '.';
        for(int i=s.length() - 1 ; i>=0;i--){
            L = len[i];
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                if(L-1 == k)return c;
            }
            else if(c == '#'){
                // double 
                long oldLen = L/2;
                if(k >= oldLen){
                    k = k - oldLen;
                }
            }
            else if(c == '%'){
                k = L - 1 - k;
            }
            else if(c == '*'){

            }
        }
        return '.';
    }
}
