package Lab3;
class Node{
    String name;
    node prev,next;

    Node(String name){
        this.prev=null;
        this.next=null;
        this.name=name;
    }}
public class DoubleLinkedList{
    Node head;

    public void insertAtBeginning(String name){
        Node newNode=new Node(name);
        insertAtBeginning(newNode);
    }
    public void insertAtBeginning(Node node){
        if(head==null){
            head=node;
        }else{
            node.next=head;
            head.prev=node;
            head=node;
        }}
    public void insertAtEnd(String name){
        Node newNode=new Node(name);
        insertAtEnd(newNode);
    }
    public void insertAtEnd(Node node){
        if(head==null){
            head=node;
        }else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
            node.prev=temp;
        }}
    public void insertAfterName(String name,Node node){
        Node temp=head;
        while(temp!=null&&!temp.name.equals(name)){
            temp=temp.next;
        }
        if(temp!=null){
            node.next=temp.next;
            node.prev=temp;
            if(temp.next!=null){
                temp.next.prev=node;
            }
            temp.next=node;
        }}

    public void insertBeforeName(String name,Node node){
        Node temp=head;
        while(temp!=null&&!temp.name.equals(name)){
            temp=temp.next;
        }
        if(temp!=null){
            node.prev=temp.prev;
            node.next=temp;
            if(temp.prev!=null){
                temp.prev.next=node;
            }else{
                head=node;
            }
            temp.prev=node;
        }}
    public void makeCircular(){
        if(head==null)return;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        head.prev=temp;
    }
    public void printAll(){
        if(head==null)return;
        Node temp=head;
        do{
            System.out.println(temp.name);
            temp=temp.next;
        }while(temp!=null&&temp!=head);
    }
    public static void main(String[] args){
        DoubleLinkedList dll=new DoubleLinkedList();
        dll.insertAtBeginning("A");
        dll.insertAtEnd("B");
        dll.insertAtEnd("C");
        dll.insertAfterName("B",new node("D"));
        dll.insertBeforeName("C",new node("E"));

        System.out.println("Before Circular:");
        dll.printAll();
        dll.makeCircular();
        System.out.println("After Circular:");
        dll.printAll();
    }}
