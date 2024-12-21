import java.util.ArrayList;

class PriorityQueueUsingSortedArray {
    private ArrayList<Integer> array;

    public PriorityQueueUsingSortedArray() {
        this.array = new ArrayList<>();
    }

    public void insert(int data) {
        try {
            int i = 0;
            while (i < array.size() && array.get(i) < data) {
                i++;
            }
            array.add(i, data);
        } catch (Exception e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }
    
    public int extractMax() {
        if (array.isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty.");
        }

        return array.remove(array.size() - 1);
    }

    public int getMax() {
        if (array.isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty.");
        }

        return array.get(array.size() - 1);
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
        PriorityQueueUsingSortedArray pq = new PriorityQueueUsingSortedArray();

        pq.insert(10);
        pq.insert(5);
        pq.insert(8);
        pq.insert(15);
        pq.insert(6);

        pq.display();

        System.out.println("Max Value: " + pq.getMax());


        System.out.println("Extracted Max: " + pq.extractMax());

        pq.display();

        System.out.println("Is 15 in the Priority Queue? " + pq.searchData(15));
        System.out.println("Is 20 in the Priority Queue? " + pq.searchData(20));
    }
}
