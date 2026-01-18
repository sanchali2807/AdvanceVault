class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here
        int sum1 = 0;
        int sum2 = 0;
        int i=0;
        int j=0;
        int res = 0;
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) < arr2.get(j)){
                sum1 += arr1.get(i);
                i++;
            }
            else if(arr1.get(i) > arr2.get(j)){
                sum2 += arr2.get(j);
                j++;
            }else{
                res += Math.max(sum1,sum2) + arr1.get(i);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        while(i<arr1.size()){
             sum1 += arr1.get(i);
                i++;
        }
        while(j<arr2.size()){
             sum2 += arr2.get(j);
                j++;
        }
        res += Math.max(sum1,sum2);
        return res;
    }
}
