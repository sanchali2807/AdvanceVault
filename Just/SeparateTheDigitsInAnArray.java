class Solution {
    void breakNum(int num , List<Integer>list){
        List<Integer> l = new ArrayList<>();
        int temp = num;
        while(temp!=0){
            int digit = temp % 10;
            l.add(digit);
            temp = temp/10;
        }
        Collections.reverse(l);
        for(int i : l){
            list.add(i);
        }
    }
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 9){
                breakNum(nums[i],list);
            }else{
                list.add(nums[i]);
            }
        }
        int[]res = new int[list.size()];
        int idx = 0;
        for(int i:list){
            res[idx++] = i;
        }
        return res;
    }
}
