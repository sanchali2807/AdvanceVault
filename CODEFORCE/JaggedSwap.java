import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            int pos1 = -1;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] == 1) {
                    pos1 = i;
                }
            }

            if (pos1 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
