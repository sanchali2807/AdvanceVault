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
    int sum;
    int maxSum;
    pair(int sum , int maxSum){
        this.sum = sum;
        this.maxSum = maxSum;
    }
 }
class Solution {
    pair maxS(TreeNode root){
        if(root == null)return new pair(0,Integer.MIN_VALUE);
        pair left = maxS(root.left);
        pair right = maxS(root.right);

        int leftBranch = Math.max(0, left.sum);
        int rightBranch = Math.max(0, right.sum);

        int branchSum = root.val + Math.max(leftBranch,rightBranch);
        int currSum = leftBranch + root.val + rightBranch;
        int currMax = Math.max(currSum , Math.max(left.maxSum,right.maxSum));
        return new pair(branchSum,currMax);

    }
    public int maxPathSum(TreeNode root) {
        if(root == null)return 0;
        return maxS(root).maxSum;
    }
}
