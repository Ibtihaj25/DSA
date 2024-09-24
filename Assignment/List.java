package Assignments;

public interface List {
    boolean isEmpty();
    int size();
    void add(Object item);
    void add(int index, Object item);
    void remove(int index);
    void remove(Object item);
    List duplicate();
    List duplicateReversed();
}
