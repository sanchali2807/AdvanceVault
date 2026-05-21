/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class pair{
    Node node;
    int vh;
    pair(Node node,int vh){
        this.node = node;
        this.vh = vh;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Queue<pair> q = new LinkedList<>();
        Map<Integer,Integer> mp = new TreeMap<>();
        q.add(new pair(root,0));
        while(!q.isEmpty()){
            pair p = q.poll();
            Node current = p.node;
            int vh = p.vh;
            
            if(!mp.containsKey(vh)){
                mp.put(vh,current.data);
            }
            if(current.left!=null){
                q.add(new pair(current.left,vh-1));
            }
            if(current.right!=null){
                q.add(new pair(current.right,vh+1));
            }
        }
        for(int e : mp.values()){
            res.add(e);
        }
        return res;
    }
}
