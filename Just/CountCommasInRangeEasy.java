class Solution {
    public int countCommas(long n) {
        if(n<1000)return 0;
        long count = 0;
        for(long i = 1000 ; i<=n;i++){
            long len = String.valueOf(i).length();
            if(len%3 == 0){
                count+=(len/3)-1;
            }else{
                count+=len/3;
            }
        }
        return (int)count;
    }
}
