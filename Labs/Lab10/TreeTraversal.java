class Node{

int data;
Node left;
Node right;
Node(int data){
    this.data=data;
    this.left=null;
    this.right=null;

}
}
public class TreeTraversal{
 
Node root;

TreeTraversal(){
    root=null;
}
    void insert(int data){
        if(root==null){
            root=new Node(data);
        }
        if(data<root.data){
            root.left=insert(root, data);
        }
        if(data>root.data){
            root.right=insert(root, data);
        }




    }


}