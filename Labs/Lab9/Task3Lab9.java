public class Task3Lab9 {
    
        Node root;
    
        class Node {
            int data;
            Node left, right;
    
            public Node(int data) {
                this.data = data;
                left = right = null;
            }
        }
    
        public Task3Lab9(int key) {
            root = new Node(key);
        }
    
        public Task3Lab9() {
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
    
        public boolean balanceTree(Node root) {
            return checkHeight(root) != -1;
        }
    
        private int checkHeight(Node node) {
            if (node == null) {
                return 0;
            }
    
            int leftHeight = checkHeight(node.left);
            if (leftHeight == -1) {
                return -1;
            }
    
            int rightHeight = checkHeight(node.right);
            if (rightHeight == -1) {
                return -1;
            }
    
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }
    
            return 1 + Math.max(leftHeight, rightHeight);
        }
    
        public static void main(String[] args) {
            Task3Lab9 tree = new Task3Lab9();
            tree.addNode(10);
            tree.addNode(5);
            tree.addNode(20);
            tree.addNode(3);
            tree.addNode(7);
    
            System.out.println("Is the tree balanced? " + tree.balanceTree(tree.root));
        }
    }
    

