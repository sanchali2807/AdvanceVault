class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int r = 0;
        int l = 0;
        while(r<n){
            if(r-l+1 == k){
                    boolean found = false;
                for(int i=l;i<=r;i++){
                    if(arr[i] < 0){
                        list.add(arr[i]);
                        found = true;
                        break;
                    }
                }
                if(!found){
                    list.add(0);
                }
                l++;
            }
            r++;
        }
        return list;
    }
}
