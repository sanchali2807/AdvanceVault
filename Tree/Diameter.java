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
 class pair{
    int h;
    int d;
    pair(int h,int d){
        this.h = h;
        this.d = d;
    }
 }
class Solution {
    pair height(TreeNode root){
        if(root == null)return new pair(0,0);
        pair left = height(root.left);
        pair right = height(root.right);
        int currHeight = 1 + Math.max(left.h,right.h);
        int currD = left.h + right.h;
        //this up line is for local
        int MaxD = Math.max(currD , Math.max(left.d,right.d));
        return new pair(currHeight,MaxD);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return height(root).d;
        
    }
}
