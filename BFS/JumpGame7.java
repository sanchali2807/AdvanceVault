class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1) != '0')return false;
        int farthest = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int i = q.poll();
            if(i == n-1)return true;
            int start = Math.max(i + minJump , farthest + 1);
            int end = Math.min(i + maxJump , n-1) ;
            for(int j = start ; j <= end ; j++){
                if(s.charAt(j) == '0'){
                    q.add(j);
                }
            }
            farthest = end;
        }
        return false;
    }
}
