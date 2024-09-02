package algorithm.sorting;

import utility.Console;

public class MergeSort {

    // Generic method to perform merge sort
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array.length < 2) {
            return; // Base case: array is already sorted
        }

        int mid = array.length / 2;
        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[array.length - mid];

        // Split the array into two halves
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // Recursively sort both halves
        sort(left);
        sort(right);

        // Merge the sorted halves
        merge(array, left, right);
    }

    // Helper method to merge two sorted subarrays into a single sorted array
    private static <T extends Comparable<T>> void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        // Merge elements from left and right arrays into the original array
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy any remaining elements of left[] (if any)
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy any remaining elements of right[] (if any)
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        // Testing with Integer class
        Integer[] array = {12, 11, 13, 5, 6};
        System.out.println("Original Array:");
        Console.printArray(array);

        MergeSort.sort(array);

        System.out.println("Sorted Array:");
        Console.printArray(array);
    }
}
