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
    int postindex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        postindex = n-1;
       TreeNode root = built(inorder,postorder,0,n-1);
       return root;
    }
    public TreeNode built(int[]in,int[]post,int st,int end){
        if(st>end)return null;
        TreeNode root = new TreeNode(post[postindex--]);
        if(st == end)return root;
        int i;
        for(i=st;i<=end;i++){
            if(in[i] == root.val){
                break;
            }
        }
        root.right = built(in,post,i+1,end);
        root.left = built(in,post,st,i-1);
        return root;
    }

}
