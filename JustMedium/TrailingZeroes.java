class Solution {
    public int trailingZeroes(int n) {
        if(n<5){
            return 0;
        }
        int val = 5;
        int count = 0;
        while(val <= n){
            count += n/val;
            val = val*5;
        }
        return count;
    }
}
