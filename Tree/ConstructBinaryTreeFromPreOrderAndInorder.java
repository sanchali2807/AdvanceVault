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
    int preOrderIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode root = built(preorder,inorder,0,n-1);
        return root;
    }
    public TreeNode built(int []preorder,int[]inorder,int st,int end){
        if(st>end)return null;
        TreeNode root = new TreeNode(preorder[preOrderIdx++]);
        if(st==end)return root;
        int i;
        for(i=st;i<=end;i++){
            if(inorder[i] == root.val){
                break;
            }
        }
        root.left = built(preorder,inorder,st,i-1);
        root.right = built(preorder,inorder,i+1,end);
        return root;
    }
}
