import java.util.LinkedList;
import java.util.Queue;

public class DepthOrder {
    Node root;
    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void Add(int data){
        root = AddNode(root , data);
    }

    public Node AddNode(Node root, int data){
        if (root == null) {
            return new Node(data);
        }
        if (root.data > data) {
            root.left = AddNode(root.left, data);
        }
        else if (root.data < data) {
            root.right = AddNode(root.right, data);
        }
        return root;
    }

    public void PreOrder(Node root){
        if (root!=null) {
            System.out.print(root.data + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    public void InOrder(Node root){
        if (root!=null) {
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }
    }

    public void PostOrder(Node root){
        if (root!=null) {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    
    

    public static void main(String[] args) {
        DepthOrder bst = new DepthOrder();
        bst.Add(5);
        bst.Add(3);
        bst.Add(6);
        bst.Add(2);
        bst.Add(4);
        System.out.print("Pre-Order: ");
        bst.PreOrder(bst.root);
        System.out.println();
        System.out.print("In-Order: ");
        bst.InOrder(bst.root);
        System.out.println();
        System.out.print("Post-Order: ");
        bst.PostOrder(bst.root);
        System.out.println();
        System.out.print("Level-Order: ");
        bst.levelOrder(bst.root);
        System.out.println();
    }
}
