class Solution {
    int reverse(int num){
        if(num<=9){
            return num;
        }
        if(num == 10){
            return 1;
        }
        int temp = num;
        int val = 0;
        while(temp!=0){
            int digit = temp%10;
            val = val * 10 + digit;
            temp = temp/10;
        }
        return val;
    }
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            st.add(nums[i]);
            st.add(reverse(nums[i]));
        }
        return st.size();
    }
}
