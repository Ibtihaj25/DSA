package Lab4;
class Stak {
    private node top;
    public Stak() {
        this.top = null;
    }
    public void push(int x) {
        node newNode = new node(x);
        newNode.next = top;
        top = newNode;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        top = top.next;
    }
    public int peek()   {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }}
public class StackImpl {
    public static void main(String[] args) {
        Stak stak = new Stak();
        stak.push(1);
        stak.push(2);
        stak.push(3);

        System.out.println("Top element is " + stak.peek());
        stak.pop();
        stak.pop();
        stak.pop();

        if (stak.isEmpty()) {
            System.out.print("Stack is empty");
        } else {
            System.out.print("Stack is not empty");
        }}}