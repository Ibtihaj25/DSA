package Lab4;
import java.util.Stack;

class Queueduostack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    Queueduostack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    public void enqueue(int data) {
        s1.push(data);
    }
    public int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) {
            return -1;
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4, 5};
        Queueduostack q = new Queueduostack();
        for (int key : keys) {
            q.enqueue(key);
        }
        System.out.println(q.dequeue());
              System.out.println(q.dequeue());
    }}