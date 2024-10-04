    package Lab3;
    class node {
        String name;
        node prev, next;

        node(String name) {
            this.name = name;
            this.prev = null;
            this.next = null;
        }
    }

    public class DoubleLinkedListWithTail {
        node head, tail;

        public void insertAtBeginning(String name) {
            node newNode = new node(name);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }

        public void insertAtEnd(String name) {
            node newNode = new node(name);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        public void removeFromBeginning() {
            if (head == null) return;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        }

        public void removeFromEnd() {
            if (tail == null) return;
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }

        public void printAll() {
            node temp = head;
            while (temp != null) {
                System.out.println(temp.name);
                temp = temp.next;
            }
        }

        public static void main(String[] args) {
            DoubleLinkedListWithTail dll = new DoubleLinkedListWithTail();

            dll.insertAtBeginning("A");
            dll.insertAtEnd("B");
            dll.insertAtEnd("C");
            dll.printAll();

            dll.removeFromBeginning();
            dll.printAll();

            dll.removeFromEnd();
            dll.printAll();
        }
    }
