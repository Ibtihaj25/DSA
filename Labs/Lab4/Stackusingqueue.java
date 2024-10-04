package Lab4;
import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    public void push(int data) {
        q2.add(data);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    public int pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.remove();
    }
    public int top() {
        if (q1.isEmpty()) {
            return -1;
        }
        return q1.peek();
    }
    public boolean isEmpty() {
        return q1.isEmpty();
    }
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }}
