package Practice;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        this.left=this.right=null;
    }
}

public class LevelOrder {
Node root;
public LevelOrder(){
    root=null;
}
public void insert(int data){
    root=insertrec(root,data);
}
private Node insertrec(Node root,int data){
    if(root==null){
        root=new Node(data);
    return root;
    }
    if(data<root.data){
        root.left=insertrec(root, data);
    }
    if(data>root.data){
        root.right=insertrec(root, data);
    }
}




}
