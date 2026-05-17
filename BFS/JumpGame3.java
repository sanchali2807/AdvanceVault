class Solution {
    class pair{
        int val;
        int idx ;
        pair(int val,int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    public boolean canReach(int[] arr, int start) {
        if(arr[start] == 0)return true;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(arr[start],start));
        arr[start] = -1;
        for(int i=0;i<arr.length;i++){
            while(!q.isEmpty()){
                pair node = q.poll();
                int val = node.val;
                int idx = node.idx;
                int value1 = idx - val;
                int value2 = val+idx;
                if(( value1 >= 0 && arr[value1] == 0 ) || ( value2 < arr.length && arr[value2] == 0))return true;
                if(value1 >= 0 && arr[value1] != -1){
                    q.add(new pair(arr[value1],value1));
                    arr[value1] = -1;
                }
                if(value2 < arr.length && arr[value2] != -1){
                    q.add(new pair(arr[value2],value2));
                    arr[value2] = -1;
                }
            }
        }
        return false;
    }
}
