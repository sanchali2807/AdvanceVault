import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        boolean possible = false;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            if(arr[i] == 0){
                possible = true;
            }
        }
        int val = Integer.MAX_VALUE;
        if(possible){
            System.out.println(0);
        }else{
            for(int i=0;i<n;i++){
                val = Math.min(val , Math.abs(arr[i] - 0));
            }
            System.out.println(val);
        }
        
    }
}
