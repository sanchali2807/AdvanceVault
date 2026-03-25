import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[]arr = new int[n];
            int count = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            boolean notsorted = false;
            for(int i=1;i<n;i++){
                if(arr[i] < arr[i-1]){
                    notsorted = true;
                    break;
                }
            }
            if(notsorted){
                System.out.println(0);
                continue;
            }
        
            for(int i=0;i<n-1;i++){
                int diff = arr[i+1] - arr[i];
                int k = diff / 2 + 1;
                count = Math.min(count,k);
            }
        System.out.println(count);
        
        }
    }
}
