import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String x = sc.next();
            String s = sc.next();
            StringBuilder str = new StringBuilder(x);
            int k = 0;
            while(str.length()<m){
                str.append(str);
                k++;
            }

            if(str.toString().contains(s)){
                System.out.println(k);
                continue;
            }
                str.append(str);
                if(str.toString().contains(s)){
                    System.out.println(k+1);
               }else{
                   System.out.println(-1);
               }
            
            
        }
    }
}
