import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            String s = sc.next();
            String[]pattern = s.split("#");
            int ans = 0;
            boolean flag = false;
            for(int i=0;i<pattern.length;i++){
                int len = pattern[i].length();
                if(len >=3){
                    flag = true;
                    break;
                }
                    ans += len;
            }
            if(flag){
                System.out.println(2);
            }
            else if(ans == 0){
                System.out.println(0);
            }
            else{
                System.out.println(ans);
            }
        }
    }
}
