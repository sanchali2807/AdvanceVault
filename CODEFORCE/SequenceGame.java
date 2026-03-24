import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[]arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            List<Integer> res = new ArrayList<>();
            res.add(arr[0]);
            for(int i=1;i<n;i++){
                if(arr[i] >= arr[i-1]){
                    res.add(arr[i]);
                }else{
                    res.add(arr[i]);
                    res.add(arr[i]);
                }
            }
            int len = res.size();
            System.out.println(len);
            for(int i=0;i<len;i++){
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
    }
}
