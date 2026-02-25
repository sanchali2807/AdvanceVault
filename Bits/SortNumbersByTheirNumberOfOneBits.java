class Solution {
    class pair{
        int count;
        int val;
        pair(int count,int val){
            this.count = count;
            this.val = val;
        }
    }
    public int[] sortByBits(int[] arr) {
        List<pair>list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int count = Integer.bitCount(arr[i]);
            list.add(new pair(count,arr[i]));
        }
        Collections.sort(list,(a,b)->{
            if(a.count != b.count){
                return a.count - b.count;
            }else{
                return a.val - b.val;
            }
        });
        int idx = 0;

        int[]res = new int[arr.length];
        for(pair i:list){
            int v = i.val;
            res[idx++] = v;
        }
        return res;
    }
}
