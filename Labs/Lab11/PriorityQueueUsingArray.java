import java.util.ArrayList;

class PriorityQueueUsingArray {
    private ArrayList<Integer> array;

    public PriorityQueueUsingArray() {
        this.array = new ArrayList<>();
    }

    public void insert(int data) {
        try {
            array.add(data);
        } catch (Exception e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }

    public int extractMax() {
        if (array.isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty.");
        }

        int maxIndex = 0;
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > array.get(maxIndex)) {
                maxIndex = i;
            }
        }

        int maxValue = array.get(maxIndex);
        array.remove(maxIndex);
        return maxValue;
    }

    public int getMax() {
        if (array.isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty.");
        }

        int maxValue = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > maxValue) {
                maxValue = array.get(i);
            }
        }

        return maxValue;
    }

    public boolean searchData(int data) {
        return array.contains(data);
    }

    public void display() {
        if (array.isEmpty()) {
            System.out.println("Priority Queue is empty.");
        } else {
            System.out.println("Elements in Priority Queue: " + array);
        }
    }

    public static void main(String[] args) {
        PriorityQueueUsingArray pq = new PriorityQueueUsingArray();

        pq.insert(10);
        pq.insert(20);
        pq.insert(15);
        pq.insert(5);

        pq.display();

        System.out.println("Max Value: " + pq.getMax());

        System.out.println("Extracted Max: " + pq.extractMax());

        pq.display();

        System.out.println("Is 15 in the Priority Queue? " + pq.searchData(15));
        System.out.println("Is 20 in the Priority Queue? " + pq.searchData(20));
    }
}
