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
            int countOdd = 0;
            for(int i=0;i<n;i++){
                if(arr[i]%2!=0){
                    countOdd++;
                }
            }
            if(countOdd % 2 == 0){
                System.out.println("YeS");
            }else{
                System.out.println("NO");
            }
        }
    }
}
