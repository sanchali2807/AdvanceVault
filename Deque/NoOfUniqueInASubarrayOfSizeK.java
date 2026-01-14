import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
         }
         Deque<Integer> dq = new ArrayDeque<>();
         Map<Integer,Integer> mp = new HashMap<>();
         int max = 0;
         for(int r =0 ;r<n;r++){
            dq.addLast(arr[r]);
            mp.put(arr[r],mp.getOrDefault(arr[r], 0)+1);
            if(dq.size()>k){
                int v = dq.removeFirst();
                mp.put(v,mp.get(v)-1);
                if(mp.get(v) == 0){
                    mp.remove(v);
                }
            }
            if(dq.size() == k){
                max = Math.max(mp.size(),max);
            }
}
         System.out.println(max);
         }
         }
