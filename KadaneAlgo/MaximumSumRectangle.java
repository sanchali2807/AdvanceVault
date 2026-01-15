class Solution {
    public int maxRectSum(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int res = Integer.MIN_VALUE;
        for(int left = 0;left<m;left++){
            int []temp = new int[n];
            for(int right = left ; right<m ;right++){
                for(int i=0;i<n;i++){
                    temp[i] += mat[i][right];
                }
                int currSum = temp[0];
                int max = temp[0];
                
                for(int i=1;i<n;i++){
                    currSum = Math.max(temp[i] , currSum+temp[i]);
                    max = Math.max(currSum,max);
                }
                res = Math.max(max,res);
            }
        }
        return res;
    }
};
