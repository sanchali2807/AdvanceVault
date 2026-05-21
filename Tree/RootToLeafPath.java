/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>>res = new ArrayList<>();
        calculatePath(root,res,new ArrayList<>());
        return res;
    }
    public void calculatePath(Node root,ArrayList<ArrayList<Integer>>res, ArrayList<Integer>list){
        if(root == null)return;
        list.add(root.data);
        if(root.right == null && root.left == null){
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        calculatePath(root.left,res,list);
        calculatePath(root.right,res,list);
        list.remove(list.size()-1);
        
    }
}
