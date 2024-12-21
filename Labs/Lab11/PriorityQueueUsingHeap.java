import java.util.ArrayList;

class PriorityQueueUsingHeap {
    private ArrayList<Integer> heap;

    public PriorityQueueUsingHeap() {
        this.heap = new ArrayList<>();
    }

    public void insert(int data) {
        heap.add(data);
        int currentIndex = heap.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            if (heap.get(currentIndex) > heap.get(parentIndex)) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        int max = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapify(0);
        }

        return max;
    }

    public int getMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }
        return heap.get(0);
    }

    private void heapify(int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        if (leftChild < heap.size() && heap.get(leftChild) > heap.get(largest)) {
            largest = leftChild;
        }
        if (rightChild < heap.size() && heap.get(rightChild) > heap.get(largest)) {
            largest = rightChild;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void display() {
        System.out.println("Heap: " + heap);
    }

    public static void main(String[] args) {
        PriorityQueueUsingHeap pq = new PriorityQueueUsingHeap();

        pq.insert(10);
        pq.insert(20);
        pq.insert(15);
        pq.insert(5);
        pq.insert(30);

        pq.display();

        System.out.println("Max Value: " + pq.getMax());

        System.out.println("Extracted Max: " + pq.extractMax());

        pq.display();
    }
}
