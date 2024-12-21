

public class IsSubTree {
   static class Node {
        int val;
        Node left, right;
    
        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public boolean isSubTree(Node x, Node y) {

        if (y == null) {
            return true;
        }

        if (x == null) {
            return false;
        }

        if (isIdentical(x, y)) {
            return true;
        }

        return isSubTree(x.left, y) || isSubTree(x.right, y);
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
        IsSubTree tree = new IsSubTree();

        Node x = new Node(1);
        x.left = new Node(2);
        x.right = new Node(3);
        x.left.left = new Node(4);
        x.left.right = new Node(5);
        x.right.left = new Node(6);
        x.right.right = new Node(7);

        Node y = new Node(3);
        y.left = new Node(6);
        y.right = new Node(7);

        System.out.println("Is y a subtree of x? " + tree.isSubTree(x, y));

        y.right.val = 8;

        System.out.println("Is y a subtree of x? " + tree.isSubTree(x, y));
    }
}
