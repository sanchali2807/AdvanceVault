class Solution {
    public int minimumDeletions(String s) {
        int bcount = 0;
        int cost = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'b'){
                bcount++;
            }else{
                cost = Math.min(cost+1,bcount);
            }
        }
        return cost;
    }
}
