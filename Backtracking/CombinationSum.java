class Solution {
    public void helper(int[]arr,int target,int idx,int sum,List<List<Integer>>res,List<Integer>list){
        if(sum > target)return;
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(idx >= arr.length)return;
        //pick 
        list.add(arr[idx]);
        helper(arr,target,idx,sum+arr[idx],res,list);
        list.remove(list.size()-1);
        //skip
        helper(arr,target,idx+1,sum,res,list);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(arr,target,0,0,res,new ArrayList<>());
        return res;
    }
}
