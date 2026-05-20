/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Tuple{
    TreeNode n;
    int v;
    int l;
    Tuple(TreeNode n,int v,int l){
        this.n = n;
        this.v = v;
        this.l = l;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,Map<Integer,List<Integer>>>mp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple node = q.poll();
            TreeNode curr = node.n;
            int v = node.v;
            int l = node.l;
            if(!mp.containsKey(v)){
                mp.put(v,new TreeMap<>());
            }
            if(!mp.get(v).containsKey(l)){
                mp.get(v).put(l,new ArrayList<Integer>());
            }
            mp.get(v).get(l).add(curr.val);
            if(curr.left!=null){
                q.add(new Tuple(curr.left,v-1,l+1));
            }
            if(curr.right!=null){
                q.add(new Tuple(curr.right,v+1,l+1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
       for(Map<Integer,List<Integer>> e : mp.values()){
        res.add(new ArrayList<>());
        for(List<Integer> i : e.values()){
            Collections.sort(i);
            for(int val : i){
                res.get(res.size()-1).add(val);
            }
        }
       }
        return res;
    }
}
