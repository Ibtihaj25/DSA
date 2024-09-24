package Lab5;

class ListNode {
    int data;
    ListNode next;
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
public class Task1 {
    ListNode head;

    public void printReverse(ListNode node) {
        if (node == null) return;
        printReverse(node.next);
        System.out.print(node.data + " ");
    }

    public void printReverse() {
        printReverse(head);
    }

    public static void main(String[] args) {
        Task1 list = new Task1();
        for(int i=0; i<5;i++)
        {list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);}
        list.printReverse();
    }
}
