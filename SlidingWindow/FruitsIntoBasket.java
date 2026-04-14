class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = fruits.length;
        int l = 0;
        int r = 0;
        int maxLen = 0;
        while(r<n){
           mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);
           while(mp.size()>2){
            mp.put(fruits[l],mp.get(fruits[l])-1);
            if(mp.get(fruits[l])==0){
                mp.remove(fruits[l]);
            }
            l++;
           }
            maxLen = Math.max(r-l+1,maxLen);
            r++;
        }
        return maxLen;
    }
}
