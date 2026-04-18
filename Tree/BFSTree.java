import java.util.*;
class tree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Tree{
        Node root;
         Node built(){
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        root.left.right.right = new Node(8);
        return root;
         }
         
         void levelTraversal(Node root){
             Queue<Node> q = new LinkedList<>();
             q.add(root);
             List<Integer> list = new ArrayList<>();
             while(!q.isEmpty()){
                 int len = q.size();
                 for(int i=0;i<len;i++){
                     Node node = q.poll();
                     list.add(node.data);
                     if(node.left!=null){
                         q.add(node.left);
                     }
                     if(node.right!=null){
                         q.add(node.right);
                     }
                 }
             }
             for(int i : list){
                 System.out.print(i+" ");
             }
         }
        }
    public static void main(String[]args){
      Tree t = new Tree();
       Node root = t.built();
       t.levelTraversal(root);
       
    }
}
