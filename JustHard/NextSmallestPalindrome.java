// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        Vector<Integer> res = new Vector<>();
        boolean allNine = true;
        for(int i=0;i<n;i++){
            if(num[i]!=9){
                allNine = false;
                break;
            }
        }
        if(allNine){
            res.add(1);
            for(int i=0;i<n-1;i++){
                res.add(0);
            }
            res.add(1);
            return res;
        }
        int[]copy = num.clone();
        for(int i=0;i<n/2;i++){
            copy[n-i-1] = copy[i];
        }
        boolean isGreater = false;
        for(int i=0;i<n;i++){
            if (copy[i] > num[i]) {
        isGreater = true;
        break;
    } else if (copy[i] < num[i]) {
        break;
    }
        }
        if(!isGreater){
            int carry = 1;
            int mid = n/2;
            if(n%2==1){
                copy[mid] += carry;
                carry = copy[mid]/10;
                copy[mid] = copy[mid]%10;
                mid--;
            }else{
                mid--;
            }
            while(mid>=0&&carry>0){
                copy[mid]+=carry;
                carry = copy[mid]/10;
                copy[mid] = copy[mid]%10;
                mid--;
            }
            for(int i=0;i<n/2;i++){
                copy[n-i-1]=copy[i];
            }
        }
        for(int i=0;i<n;i++){
            res.add(copy[i]);
        }
        return res;
        
    }
}
