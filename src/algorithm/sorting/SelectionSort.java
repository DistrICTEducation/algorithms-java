package algorithm.sorting;

import utility.Console;

public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        // Testing with Integer class
        Integer[] array = {12, 11, 13, 5, 6};
        System.out.println("Original Array:");
        Console.printArray(array);

        SelectionSort.sort(array);

        System.out.println("Sorted Array:");
        Console.printArray(array);
    }
}
