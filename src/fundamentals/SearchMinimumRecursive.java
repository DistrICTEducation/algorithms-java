package fundamentals;

/**
 * Implementation for searching the minimum value in an array of integers.
 * Loop through the items of the array recursively, retaining the value that is lowest so far. If the last element is reached,
 * return the lowest value found.
 * 
 * @author  Joris Schelfaut
 * @version 1.0.0
 * @since   1.0.0
 */
public class SearchMinimumRecursive {

    public static int searchMinimum(int[] i_array) {
        // Initialise the recursion with index 0 and lowest value set to positive infinity
        return searchMinimumRecursive(i_array, 0, Integer.MAX_VALUE);
    }

    private static int searchMinimumRecursive(int[] i_array, int i_current_index, int i_minimum_value) {

        // As long as the index is lower than the array length, continue with the recursion,
        // but update the index in the next step;
        // also update the current lowest value.
        if (i_current_index < i_array.length) {
            if (i_minimum_value > i_array[i_current_index])
                i_minimum_value = i_array[i_current_index];
            return searchMinimumRecursive(i_array, i_current_index + 1, i_minimum_value);
        }
        // If the end has been reached, simply return the last found minimum value
        // this ends the recursion.
        else {
            return i_minimum_value;
        }
    }

    public static void main(String[] args) {

        int[] myArray1 = { 4, 2, 1, 3, 5 };
        int minimum_value1 = searchMinimum(myArray1);
        System.out.println("The lowest value is: " + minimum_value1 + ".");

        int[] myArray2 = { 461, 233, 101, 13, 55, 69, 48, 101, 77 };
        int minimum_value2 = searchMinimum(myArray2);
        System.out.println("The lowest value is: " + minimum_value2 + ".");
    }
}
