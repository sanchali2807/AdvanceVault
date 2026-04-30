// Java program to Generate all binary 
// strings without consecutive 1's
import java.util.*;

class Main {
    static void helper(StringBuilder str ,int idx ,int n, List<String>res){
        if(idx == n){
            res.add(new String(str.toString()));
            return;
        }
        str.setCharAt(idx,'0');
        helper(str,idx+1,n,res);
        if(idx == 0 || str.charAt(idx-1) != '1'){
            str.setCharAt(idx,'1');
            helper(str,idx+1,n,res);
        }
    }
    static List<String> generateBinaryStrings(int n) {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<n;i++){
            str.append('0');
        }
        List<String>res = new ArrayList<>();
        helper(str,0,n,res);
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        List<String> res = generateBinaryStrings(n);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
