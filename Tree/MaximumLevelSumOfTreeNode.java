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
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        List<pair> NodeSum = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i=0;i<size;i++){
            TreeNode node = q.poll();
                sum += node.val;
            
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
            }
            NodeSum.add(new pair(level,sum));
            level++;
        }
        int max = Integer.MIN_VALUE;
        int node = 0;
        for(pair i: NodeSum){
            int l = i.l;
            int s = i.sum;
            if(s>max){
                max = s;
                node = l;
            }else if(s == max){
                if(l<node){
                    node=l;
                }
            }

        }
        return node;
    }
    class pair{
        int l;
        int sum;
        pair(int l,int sum){
            this.l = l;
            this.sum=sum;
        }
    }
}
