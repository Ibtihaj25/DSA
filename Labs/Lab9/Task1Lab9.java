public class Task1Lab9 {
    
        Node root;
    
        class Node {
            int data;
            Node left, right;
    
            public Node(int data) {
                this.data = data;
                left = right = null;
            }
        }
    
        public Task1Lab9(int key) {
            root = new Node(key);
        }
    
        public Task1Lab9() {
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
    
        public boolean searchNode(int data) {
            return searchNodeRecursive(root, data);
        }
    
        private boolean searchNodeRecursive(Node current, int data) {
            if (current == null) {
                return false;
            }
            if (data == current.data) {
                return true;
            }
            return data < current.data
                ? searchNodeRecursive(current.left, data)
                : searchNodeRecursive(current.right, data);
        }
    
        public int countOfNodes(Node node) {
            if (node == null) {
                return 0;
            }
            return 1 + countOfNodes(node.left) + countOfNodes(node.right);
        }
    
        public int height(Node node) {
            if (node == null) {
                return 0;
            }
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    
        public static void main(String[] args) {
            Task1Lab9 tree = new Task1Lab9();
            tree.addNode(10);
            tree.addNode(5);
            tree.addNode(20);
            tree.addNode(3);
            tree.addNode(7);
    
            System.out.println("Is 7 in the tree? " + tree.searchNode(7));
            System.out.println("Is 15 in the tree? " + tree.searchNode(15));
            System.out.println("Total nodes in tree: " + tree.countOfNodes(tree.root));
            System.out.println("Height of tree: " + tree.height(tree.root));
       
    }
    
}
