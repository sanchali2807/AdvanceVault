class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int l = 0;
        int r = 0;
        int trues = 0;
        int falses = 0;
        int len = 0;
        while(r<n){
            if(answerKey.charAt(r) == 'T')trues++;
            else falses++;
            while(Math.min(trues,falses)>k){
                if(answerKey.charAt(l) == 'T')trues--;
                else falses--;
                l++;
            }
            len = Math.max(r-l+1,len); 
            r++;
        }
        return len;
    }
}
