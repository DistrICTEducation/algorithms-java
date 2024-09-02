package datastructure;

public class LinkedList<T> {
    private Node<T> head;  // Head of the list
    private int size;      // Size of the list

    // Node class representing each element in the list
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor to initialize the linked list
    public LinkedList() {
        head = null;
        size = 0;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the list
    public int size() {
        return size;
    }

    // Method to add an element to the end of the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Method to add an element at a specific index in the list
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> newNode = new Node<>(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // Method to remove an element from the list
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedNode = current.next;
            current.next = removedNode.next;
        }
        size--;
        return removedNode.data;
    }

    // Method to get the element at a specific index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Method to clear the list
    public void clear() {
        head = null;
        size = 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

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
