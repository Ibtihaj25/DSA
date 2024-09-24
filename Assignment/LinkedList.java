package Assignments;
public class LinkedList implements List {

    private Node head;
    private int size;

    public LinkedList() {
        head = new Node(null);
        size = 0;   }

    private class Node {
        Object data;
        Node next;
        public Node(Object data) {
            this.data = data;
            this.next = null;        }    }

    @Override
    public boolean isEmpty() {
        return size == 0;}
    @Override
    public int size() {
        return size;    }
    @Override
    public void add(Object item) {
        Node newNode = new Node(item);
        Node current = head;
        while (current.next != null) {
            current = current.next;}
        current.next = newNode;
        size++;    }
    @Override
    public void add(int index, Object item) {
        if (index < 1 || index > size + 1) {
            return;}
        Node newNode = new Node(item);
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;}

        newNode.next = current.next;
        current.next = newNode;
        size++;}

    @Override
    public void remove(int index) {
        if (index < 1 || index > size) {
            return;
        }
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }
    @Override
    public void remove(Object item) {
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(item)) {
                current.next = current.next.next;
                size--;
                return;}
            current = current.next;}    }
    @Override
    public List duplicate() {
        LinkedList duplicateList = new LinkedList();
        Node current = head.next;
        while (current != null) {
            duplicateList.add(current.data);
            current = current.next;}
        return duplicateList;    }
    @Override
    public List duplicateReversed() {
        LinkedList reversedList = new LinkedList();
        Node current = head.next;
        while (current != null) {
            reversedList.add(1, current.data);
            current = current.next;}
        return reversedList;}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ size: ").append(size).append(" - ");
       Node current = head.next;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
            if (current != null) {
                sb.append(", ");}}
        sb.append(" ]");
        return sb.toString();}
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add(1, "C");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        LinkedList duplicateList = (LinkedList) list.duplicate();
        System.out.println("Duplicate " +duplicateList);
        LinkedList reversedList = (LinkedList) list.duplicateReversed();
        System.out.println("Reversed  "+reversedList);     }}