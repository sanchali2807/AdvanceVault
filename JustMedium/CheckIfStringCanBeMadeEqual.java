class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n!=m){
            return false;
        }
        char[]s1even = new char[n + 1 / 2];
        char[]s1odd = new char[n/2];
        char[]s2even = new char[m + 1 / 2];
        char[]s2odd = new char[m/2];
        int e = 0;
        int o = 0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                s1even[e] = s1.charAt(i);
                s2even[e] = s2.charAt(i);
                e++;
            }else{
                s1odd[o] = s1.charAt(i);
                s2odd[o] = s2.charAt(i);
                o++;
            }
        }

        Arrays.sort(s1even);
        Arrays.sort(s2even);
        Arrays.sort(s1odd);
        Arrays.sort(s2odd);
        return Arrays.equals(s1even,s2even) && Arrays.equals(s2odd,s1odd);

    }
}
