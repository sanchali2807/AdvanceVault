class Solution {
    boolean valid(String s){
        if(s.length() > 1 && s.startsWith("0"))return false;
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> res = new ArrayList<>();
        int count = 0;
        for(int i=1;i<=3;i++){
            for(int j=i+1;j<=i+3;j++){
                for(int k=j+1;k<=j+3;k++){
                    if(k>=n)continue;
                    String a = s.substring(0,i);
                    String b = s.substring(i,j);
                    String c = s.substring(j,k);
                    String d = s.substring(k);
                    if(a.length() > 3 || b.length() > 3 || c.length() > 3 || d.length() > 3)continue;
                    if(valid(a) && valid(b) && valid(c) && valid(d)){
                        res.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return res;
    }
}
