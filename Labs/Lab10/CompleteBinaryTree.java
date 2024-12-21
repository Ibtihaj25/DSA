package Lab10;

import java.util.LinkedList;
import java.util.Queue;

class CompleteBinaryTree {
    static class Node {
        int val;
        Node left, right;
    
        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    Node root;
    Queue<Node> queue;

    public CompleteBinaryTree() {
        root = null;
        queue = new LinkedList<>();
    }

    public void add(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
        } else {
            Node parent = queue.peek();

            if (parent.left == null) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
                queue.poll();
            }
        }

        queue.add(newNode);
    }

    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<Node> traversalQueue = new LinkedList<>();
        traversalQueue.add(root);

        while (!traversalQueue.isEmpty()) {
            Node currentNode = traversalQueue.poll();
            System.out.print(currentNode.val + " ");

            if (currentNode.left != null) {
                traversalQueue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                traversalQueue.add(currentNode.right);
            }
        }
        System.out.println();
    }

    public boolean isComplete(Node root) {
        if (root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean foundNullChild = false;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null) {
                if (foundNullChild) {
                    return false;
                }
                queue.add(temp.left);
            } else {
                foundNullChild = true;
            }

            if (temp.right != null) {
                if (foundNullChild) {
                    return false;
                }
                queue.add(temp.right);
            } else {
                foundNullChild = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CompleteBinaryTree cbTree = new CompleteBinaryTree();
    
        cbTree.add(1);
        cbTree.add(2);
        cbTree.add(3);
        cbTree.add(4);
        cbTree.add(5);
        cbTree.add(6);
        cbTree.add(7);
    
        System.out.print("Level Order Traversal: ");
        cbTree.levelOrderTraversal();
        
        // Print the result of isComplete
        System.out.println("Is the binary tree complete? " + cbTree.isComplete(cbTree.root));
    }
}
