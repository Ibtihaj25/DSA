public class Task2Lab9 {
    
        Node root;
    
        class Node {
            int data;
            Node left, right;
    
            public Node(int data) {
                this.data = data;
                left = right = null;
            }
        }
    
        public Task2Lab9(int key) {
            root = new Node(key);
        }
    
        public Task2Lab9() {
            root = null;
        }
    
        public void addNode(int data) {
            root = addNodeRecursive(root, data);
        }
    
        private Node addNodeRecursive(Node current, int data) {
            if (current == null) {
                return new Node(data);
            }
            if (data < current.data) {
                current.left = addNodeRecursive(current.left, data);
            } else if (data > current.data) {
                current.right = addNodeRecursive(current.right, data);
            }
            return current;
        }
    
        public int minNumber() {
            return minNumberRecursive(root);
        }
    
        private int minNumberRecursive(Node current) {
            if (current == null) {
                throw new IllegalArgumentException("Tree is empty");
            }
            while (current.left != null) {
                current = current.left;
            }
            return current.data;
        }
    
        public int maxNumber() {
            return maxNumberRecursive(root);
        }
    
        private int maxNumberRecursive(Node current) {
            if (current == null) {
                throw new IllegalArgumentException("Tree is empty");
            }
            while (current.right != null) {
                current = current.right;
            }
            return current.data;
        }
    
        public static void main(String[] args) {
            Task2Lab9 tree = new Task2Lab9();
            tree.addNode(10);
            tree.addNode(5);
            tree.addNode(20);
            tree.addNode(3);
            tree.addNode(7);
    
            System.out.println("Minimum value in the tree: " + tree.minNumber());
            System.out.println("Maximum value in the tree: " + tree.maxNumber());
        }
    
    
}
