import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int x = sc.nextInt();
            int k = sc.nextInt();

            // Case 1: x is NOT divisible by k
            if (x % k != 0) {
                System.out.println(1);
                System.out.println(x);
            } 
            // Case 2: x is divisible by k
            else {
                System.out.println(2);
                System.out.println("1 " + (x - 1));
            }
        }
    }
}
