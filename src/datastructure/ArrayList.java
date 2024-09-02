package datastructure;

import java.util.Arrays;

public class ArrayList<T> {
    private T[] array;
    private int size;

    // Constructor to initialize the ArrayList with an initial capacity
    public ArrayList() {
        array = (T[]) new Object[10]; // Default initial capacity
        size = 0;
    }

    // Method to get the size of the ArrayList
    public int size() {
        return size;
    }

    // Method to check if the ArrayList is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the element at a specific index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    // Method to add an element to the end of the ArrayList
    public void add(T data) {
        ensureCapacity(size + 1);
        array[size++] = data;
    }

    // Method to add an element at a specific index
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = data;
        size++;
    }

    // Method to remove an element at a specific index
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T removedElement = array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null; // Clear to let GC do its work
        return removedElement;
    }

    // Method to clear the ArrayList
    public void clear() {
        Arrays.fill(array, 0, size, null);
        size = 0;
    }

    // Method to ensure the internal array has enough capacity
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array.length) {
            int newCapacity = array.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Element at index 1: " + list.get(1)); // Output: 20
        System.out.println("List size is: " + list.size());       // Output: 3

        list.add(1, 15);
        System.out.println("Element at index 1 after insertion: " + list.get(1)); // Output: 15

        System.out.println("Removed element: " + list.remove(2)); // Output: 20
        System.out.println("Element at index 2: " + list.get(2)); // Output: 30
        System.out.println("List size is: " + list.size());       // Output: 3

        list.clear();
        System.out.println("List size after clearing: " + list.size()); // Output: 0
    }
}
