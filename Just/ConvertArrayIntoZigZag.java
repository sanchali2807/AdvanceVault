class Solution {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void zigZag(int[] arr) {
        int n = arr.length;

        for(int i=1;i<n-1;i++){
            if(i%2==0){
                if(arr[i] > arr[i-1] || arr[i] > arr[i+1]){
                    if(arr[i-1] < arr[i+1]){
                        swap(arr, i, i-1);
                    }else{
                        swap(arr, i, i+1);
                    }
                }
            }else{
                if(arr[i] < arr[i-1] || arr[i] < arr[i+1]){
                    if(arr[i-1] > arr[i+1]){
                        swap(arr, i, i-1);
                    }else{
                        swap(arr, i, i+1);
                    }
                }
            }
        }
    }
}
