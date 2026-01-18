// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Map<Long,Long> mp = new TreeMap<>();
        int n = 5;
        for(int i=0;i<n;i++){
        long id = sc.nextLong();
        long count = sc.nextLong();
        String status = sc.next();
        long delta = status.equals("E") ? count : -count;
        mp.put(id,mp.getOrDefault(id,0L)+delta);
        }
    long curr =0;
    long sT = 0;
    long eT = 0;
    Long prev = null;
    long max = 0;
        for(Map.Entry<Long,Long> e : mp.entrySet()){
            long key = e.getKey();
            long c = e.getValue();
            if(prev!=null){
                if(curr == max){
                    eT = key;
                }
            }
            curr += c;
            if(curr > max){
                max = curr;
                sT = key;
                eT = key;
            }
            prev = key;
        }
        System.out.print(sT + " " + eT);
    }
}
