class Solution {
    public String makeLargestSpecial(String s) {
        int count = 0;
        int start = 0;
        if (s.length() <= 2) {
            return s;
        }
        List<String> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                String temp = s.substring(start+1,i);
                start = i+1;
                String InnerPart = makeLargestSpecial(temp);
                list.add("1"+InnerPart+"0");
            }
        }
        Collections.sort(list,Collections.reverseOrder());
        StringBuilder str = new StringBuilder();
        for(String i:list){
            str.append(i);
        }
        return str.toString();
    }
}
