            package Assignments;
            public class LinkedListRemoveDuplicates{
                static class Node{
                    int data;
                    Node next;
                    Node(int data){
                        this.data=data;
                        this.next=null;
                    }
                }
                static class LinkedList{
                    Node head;
                    public void insert(int data){
                        Node newNode=new Node(data);
                        if(head==null){
                            head=newNode;
                        }else{
                            Node current=head;
                            while(current.next!=null){
                                current=current.next;
                            }
                            current.next=newNode;
                        }
                    }
                    public void removeDuplicates(){
                        if(head==null){
                            return;
                        }
                        Node current=head;
                        while(current!=null&&current.next!=null){
                            Node runner=current;
                            while(runner.next!=null){
                                if(current.data==runner.next.data){
                                    runner.next=runner.next.next;
                                }else{
                                    runner=runner.next;
                                }
                            }
                            current=current.next;
                        }
                    }
                    public void printList(){
                        Node current=head;
                        while(current!=null){
                            System.out.print(current.data+" ");
                            current=current.next;
                        }
                        System.out.println();
                    }
                }
                public static void main(String[] args){
                    LinkedList list=new LinkedList();
                    list.insert(5);
                    list.insert(3);
                    list.insert(4);
                    list.insert(5);
                    list.insert(2);
                    list.insert(1);
                    list.insert(4);
                    list.insert(5);
                    list.insert(3);
                    list.removeDuplicates();
                    list.printList();
                }
            }
                        