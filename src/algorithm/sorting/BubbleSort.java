package algorithm.sorting;

import utility.Console;

public class BubbleSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Traverse the array from 0 to n-i-1
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the element found is greater than the next element
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by the inner loop, then break
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        // Testing with Integer class
        Integer[] array = {12, 11, 13, 5, 6};
        System.out.println("Original Array:");
        Console.printArray(array);

        BubbleSort.sort(array);

        System.out.println("Sorted Array:");
        Console.printArray(array);
    }
}
