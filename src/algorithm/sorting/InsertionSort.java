package algorithm.sorting;

import utility.Console;

public class InsertionSort {

    public static <T extends Comparable<T>> void sort(T[] io_array) {
        int n = io_array.length;
        for (int i = 1; i < n; i++) {
            T key = io_array[i];
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && io_array[j].compareTo(key) > 0) {
                io_array[j + 1] = io_array[j];
                j = j - 1;
            }
            io_array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // Testing with Integer class
        Integer[] array = {12, 11, 13, 5, 6};
        System.out.println("Original Array:");
        Console.printArray(array);

        InsertionSort.sort(array);

        System.out.println("Sorted Array:");
        Console.printArray(array);
    }
}
