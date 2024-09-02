package algorithm.sorting;

import utility.Console;

public class ShellSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform a gapped insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                // Save array[i] and make a hole at position i
                T temp = array[i];

                // Shift earlier gap-sorted elements up until the correct location for array[i] is found
                int j;
                for (j = i; j >= gap && array[j - gap].compareTo(temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }

                // Put temp (the original array[i]) in its correct location
                array[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // Testing with Integer class
        Integer[] array = {12, 11, 13, 5, 6};
        System.out.println("Original Array:");
        Console.printArray(array);

        ShellSort.sort(array);

        System.out.println("Sorted Array:");
        Console.printArray(array);
    }
}
