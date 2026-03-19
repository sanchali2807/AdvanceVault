class Solution {
    public long countCommas(long n) {
        long start = 1000;
        long count = 0;
        int commas = 1;
        while(start <= n){
            long val = start * 1000 - 1;
            long min = Math.min(val,n);
            count +=(min - start + 1) * commas;
            commas++;
            start = start * 1000;
        }
        return count;
    }
}
