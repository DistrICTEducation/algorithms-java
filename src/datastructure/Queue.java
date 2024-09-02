package datastructure;

public class Queue<T> {
    private Node<T> front;  // Front of the queue
    private Node<T> rear;   // Rear of the queue
    private int size;       // Size of the queue

    // Node class representing each element in the queue
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor to initialize the queue
    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the queue
    public int size() {
        return size;
    }

    // Method to add an element to the queue (enqueue)
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Method to remove an element from the queue (dequeue)
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {  // If the queue is now empty after dequeuing
            rear = null;
        }
        size--;
        return data;
    }

    // Method to get the element at the front of the queue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    // Method to clear the queue
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element is: " + queue.peek()); // Output: 10
        System.out.println("Queue size is: " + queue.size());    // Output: 3

        System.out.println("Dequeued: " + queue.dequeue());      // Output: 10
        System.out.println("Front element is: " + queue.peek()); // Output: 20
        System.out.println("Queue size is: " + queue.size());    // Output: 2

        queue.clear();
        System.out.println("Queue size after clearing: " + queue.size()); // Output: 0
    }
}
