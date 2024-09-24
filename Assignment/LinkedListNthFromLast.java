package Assignments;

public class LinkedListNthFromLast {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        static final int LIST_EMPTY = -1;

        public void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
        public int nthFromLast(int n) {
            if (head == null) {
                return LIST_EMPTY;
            }

            Node first = head;
            Node second = head;

            for (int i = 0; i < n; i++) {
                if (first == null) {
                    return LIST_EMPTY;
                }
                first = first.next;
            }

            while (first != null) {
                first = first.next;
                second = second.next;
            }

            return second.data;
        }

        public void printList() {
            Node current = head;
            while (current != null) {
                        System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println(list.nthFromLast(2));
    }
}
