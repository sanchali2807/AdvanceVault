class Solution {
    void fun(int k,int n,int val,int sum,List<List<Integer>>res,List<Integer> list ){
        if(list.size() == k && sum == n){
            res.add(new ArrayList<>(list));
            return;
        }
        if(val>9)return;
        if(sum > n)return;
        // take 
        list.add(val);
        fun(k,n,val+1,sum+val,res,list);
        list.remove(list.size()-1); 
        // skip
        fun(k,n,val+1,sum,res,list);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        fun(k,n,1,0,res,new ArrayList<>());
        return res;
    }
}
