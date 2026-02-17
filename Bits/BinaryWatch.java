class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        for(int h=0;h<12;h++){
            for(int m=0;m<60;m++){
                int bits = Integer.bitCount(h) + Integer.bitCount(m);
                if(bits == turnedOn){
                    String time = h + ":" + (m<10?"0"+m:m);
                    list.add(time);
                }
            }
        }
        return list;
    }
}
