package Lab3;
class Nde {
    int data;
    Nde next;

    Nde(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListCycle {

    public static boolean hasCycle(Nde head) {
        if (head == null) return false;

        Nde slow = head;
        Nde fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Nde head = new Nde(1);
        head.next = new Nde(2);
        head.next.next = new Nde(3);


        head.next.next.next = head.next;
        if (hasCycle(head)) {
            System.out.println("Cycle detected.");
        } else {
            System.out.println("No cycle detected.");
        }
    }
}

