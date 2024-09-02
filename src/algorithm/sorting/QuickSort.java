package algorithm.sorting;

import utility.Console;

public class QuickSort {

    // Generic method to perform quicksort
    public static <T extends Comparable<T>> void sort(T[] array) {
        recursion(array, 0, array.length - 1);
    }

    // Helper method to perform quicksort recursively
    private static <T extends Comparable<T>> void recursion(T[] array, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(array, low, high);

            // Recursively sort elements before and after partition
            recursion(array, low, pi - 1);
            recursion(array, pi + 1, high);
        }
    }

    // Method to partition the array and return the pivot index
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1; // Index of the smaller element

        for (int j = low; j < high; j++) {
            // If the current element is less than or equal to the pivot
            if (array[j].compareTo(pivot) <= 0) {
                i++;

                // Swap array[i] and array[j]
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i + 1] and array[high] (or pivot)
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        // Testing with Integer class
        Integer[] array = {12, 11, 13, 5, 6};
        System.out.println("Original Array:");
        Console.printArray(array);

        QuickSort.sort(array);

        System.out.println("Sorted Array:");
        Console.printArray(array);
    }
}
