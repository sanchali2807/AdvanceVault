class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int res [] = new int[A.length];
        int n = A.length;
        int [] freq = new int[n+1];
        for(int i=0;i<n;i++){
            freq[A[i]]++;
            freq[B[i]]++;
            int count = 0;
            for(int j=0;j<n+1;j++){
                if(freq[j] == 2){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
