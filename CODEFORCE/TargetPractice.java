import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            char[][]grid = new char[10][10];
            int n =10 ; int m = 10;
            for(int i=0;i<n;i++){
                String s = sc.next();
                for(int j=0;j<m;j++){
                    grid[i][j] = s.charAt(j);
                }
            }
            int top = 0;
            int bottom = n-1;
            int left = 0;
            int right = m-1;
            int sum = 0;
            int val = 1;
            while(top<=bottom && left<=right){
                int count = 0;
                //top row
                for(int i=left;i<=right;i++){
                    if(grid[top][i] == 'X'){
                        count++;
                    }
                }
                // last column and add 1 to avoid corners
                for(int i=top+1;i<=bottom;i++){
                    if(grid[i][right] == 'X'){
                        count++;
                    }
                }
                //last row
                for(int i=right-1;i>=left;i--){
                    if(grid[bottom][i] == 'X'){
                        count++;
                    }
                }
                // first column
                for(int i=bottom-1;i>top;i--){
                    if(grid[i][left] == 'X'){
                        count++;
                    }
                }
                sum += (val)*(count);
                val++;
                top++;
                bottom--;
                left++;
                right--;
            }
        System.out.println(sum);
        }
    }
}
