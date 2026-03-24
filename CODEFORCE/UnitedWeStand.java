import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[]arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            List<Integer> b = new ArrayList<>();
            List<Integer> c = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                min = Math.min(min,arr[i]);
            }
            Arrays.sort(arr);
            for(int i=0;i<n;i++){
                if(arr[i]<=min){
                    b.add(arr[i]);
                }else{
                    c.add(arr[i]);
                }
            }
            int lenB = b.size();
            int lenC = c.size();
            if(lenB == 0 || lenC == 0){
                System.out.println(-1);
            }else{
                System.out.println(lenB + " " + lenC);
                for(int i : b){
                    System.out.print(i+" ");
                }
                System.out.println();
                for(int i : c){
                    System.out.print(i+" ");
                }
                System.out.println();
            }
        }
        
    }
}
