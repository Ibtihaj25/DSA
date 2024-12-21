

public class IsIdentical {
   static class Node {
        int val;
        Node left, right;
    
        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public boolean isIdentical(Node x, Node y) {

        if (x == null && y == null) {
            return true;
        }

        if (x == null || y == null) {
            return false;
        }

        return (x.val == y.val) 
                && isIdentical(x.left, y.left) 
                && isIdentical(x.right, y.right);
    }

    public static void main(String[] args) {
        IsIdentical tree = new IsIdentical();

        
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        System.out.println("Are the two trees identical? " + tree.isIdentical(root1, root2));

        
        root2.right.left = new Node(6);

        System.out.println("Are the two trees identical? " + tree.isIdentical(root1, root2));
    }
}
