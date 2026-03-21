import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            String s = sc.next();

            int i = 0, j = n - 1;

            while(i < j && s.charAt(i) != s.charAt(j)){
                i++;
                j--;
            }

            System.out.println(j - i + 1);
        }
    }
}
