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
            int x = (n+1)/2;
            Arrays.sort(arr);
            Map<Integer,Integer>mp = new HashMap<>();
            for(int i=0;i<n;i++){
                mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
            }
            int max = 0;
            for(Map.Entry<Integer,Integer>e:mp.entrySet()){
                max = Math.max(e.getValue(),max);
            }
            int dis = mp.size();
            if(dis == 1){
                System.out.println("YES");
            }
            else if(dis<=2 && max ==x){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
