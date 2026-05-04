class Solution {
    void fun(int[]nums,List<Integer>list,List<List<Integer>>res,int idx){
        res.add(new ArrayList<>(list));
        if(idx >= nums.length)return;
        for(int i = idx;i<nums.length;i++){
        list.add(nums[i]);
        fun(nums,list,res,i+1);
        list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        fun(nums,new ArrayList<>(),res,0);
        return res;
    }
}
