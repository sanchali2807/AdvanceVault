class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int [] count = new int[26];
        if(p.length()>s.length()){
            return res;
        }
        for(int i = 0 ;i<p.length() ;i++){
            count[p.charAt(i)-'a']++;
        }
        int [] check = new int[26];
        int n = s.length();
        int m = p.length();
        for(int i=0 ;i<m ;i++){
            check[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(count,check)){

        res.add(0);
        }
        int j=0;
        j=m;
        for(int i=0;i<n-m;i++){
            check[s.charAt(i)-'a']--;
            check[s.charAt(j++)-'a']++;
            if(Arrays.equals(check,count)){
                res.add(i+1);
            }
        }
        return res;

    }
}
