
 import java.util.*;
public class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        long d = sc.nextLong();
        long[]arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextLong();
        }
        // Arrays.sort(arr);
        int r = 0;
        long count = 0;
        for(int i=0;i<n;i++){
           while(r<n && arr[r]-arr[i]<=d){
               r++;
           }
           long k = (r-1) - (i+1) + 1;
           // formula to calculate no of points
           if(k>=2){
               count += ((k)*(k-1))/2;
           }
        }
        System.out.println(count);
    }
}
