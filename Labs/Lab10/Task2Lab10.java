
  public class Task2Lab10 {

    public class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data > root.data) {
            root.right = insertRec(root.right, data); 
        } else if (data < root.data) {
            root.left = insertRec(root.left, data); 
        }

        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    public int height(Node root){
        if(root== null){
            return 0;
        }
        int left= height(root.left);
        int right = height(root.right);
        if(left > right){
            return left+1;
        }
        else{
            return right+1;
        }
      }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(7);
        tree.insert(11);
        tree.insert(2);
        tree.insert(9);
        tree.inorder();
        
        
        
    }
}
