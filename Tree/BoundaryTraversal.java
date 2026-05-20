/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    boolean isLeaf(Node root){
        if(root.left == null && root.right == null)return true;
        return false;
    }
    void addLeftBoundary(Node root,ArrayList<Integer>ans){
        Node curr = root.left;
        while(curr!=null){
            if(!isLeaf(curr))ans.add(curr.data);
            if(curr.left != null)curr = curr.left;
            else curr = curr.right;
        }
    }
    void addLeafs(Node root,ArrayList<Integer>ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if(root.left!=null)addLeafs(root.left,ans);
        if(root.right!=null)addLeafs(root.right,ans);
    }
    void addRightBoundary(Node root,ArrayList<Integer>ans){
        Node current = root.right;
        Stack<Node> st = new Stack<>();
        while(current != null){
            if(!isLeaf(current))st.push(current);
            if(current.right!=null)current = current.right;
            else current = current.left;
        }
        while(!st.isEmpty()){
            ans.add(st.pop().data);
        }
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
       ArrayList<Integer> ans = new ArrayList<>();
       if(!isLeaf(root)) ans.add(root.data);
       addLeftBoundary(root,ans);
       addLeafs(root,ans);
       addRightBoundary(root,ans);
       return ans;
        
    }
}
