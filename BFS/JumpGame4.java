class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        int jump = 0;
        Map<Integer,List<Integer>>mp = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[]visit = new boolean[n];
        q.add(0);
        visit[0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int node = q.poll();
                if(node == n-1)return jump;
                if(node - 1 >=0 && !visit[node-1]){
                    visit[node-1] = true;
                    q.add(node-1);
                }
                if(node + 1 < n && !visit[node+1]){
                    visit[node+1] = true;
                    q.add(node+1);
                }

                List<Integer> sameIndex = mp.get(arr[node]);
                if(mp.containsKey(arr[node])){

    for(int j : mp.get(arr[node])){

        if(!visit[j]){
            visit[j] = true;
            q.add(j);
        }
    }

    mp.remove(arr[node]);
}
            }
            jump++;
        }
        return jump;
    }
}
