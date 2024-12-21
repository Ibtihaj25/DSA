public class MyArrayList<T> {
    private T[] asArray;
    private int size;

    public MyArrayList() {
        asArray = (T[]) new Object[10];
        size = 0;
    }

    public void add(T value) {
        ensureCapacity();
        asArray[size++] = value;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ensureCapacity();

        for (int i = size; i > index; i--) {
            asArray[i] = asArray[i - 1];
        }
        asArray[index] = value;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            asArray[i] = asArray[i + 1];
        }
        asArray[--size] = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (asArray[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        asArray[index] = value; // Replace the element
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return asArray[index];
    }

    // Ensures the array has enough capacity for new elements
    private void ensureCapacity() {
        if (size == asArray.length) {
            T[] newArray = (T[]) new Object[asArray.length * 2 + 1]; // Double capacity
            System.arraycopy(asArray, 0, newArray, 0, size); // Copy elements
            asArray = newArray; // Replace old array with new array
        }
    }

    public void display() {
        System.out.print("MyArrayList: [");
        for (int i = 0; i < size; i++) {
            System.out.print(asArray[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        list.display();

        list.insert(1, 15);
        list.display();
        list.delete(2);
        list.display();

        list.set(1, 25);
        list.display();

        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("List contains 25: " + list.contains(25));

        System.out.println("List is empty: " + list.isEmpty());

        System.out.println("List size: " + list.size());
    }
}
