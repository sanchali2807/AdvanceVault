
class Solution {
    static int nextGreaterCount(int[]arr,int idx,int val){
        int count = 0;
        for(int i = idx+1 ; i<arr.length;i++){
            if(arr[i] > val){
                count++;
            }
        }
        return count;
    }
    public static int[] count_NGE(int arr[], int ind[]) {
        // code here
        int[]res = new int[ind.length];
        for(int i=0;i<ind.length;i++){
            res[i] = nextGreaterCount(arr,ind[i],arr[ind[i]]);
        }
        return res;
    }
}
