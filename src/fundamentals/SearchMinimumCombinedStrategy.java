package fundamentals;


/**
 * Implementation for searching the minimum value in an array of integers.
 * Apply a divide and conquer strategy until the sub-array length is less than a given threshold value.
 * Beyond that, use another strategy instead (in this case the simple loop method).
 * Combining strategies may sometimes be advantageous for certain optimizations. The example given here is mainly for
 * illustration.
 * 
 * @author  Joris Schelfaut
 * @version 1.0.0
 * @since   1.0.0
 */
public class SearchMinimumCombinedStrategy {
    
    public static int searchMinimum(int[] i_array) {
        
        // Finding the lowest value of an empty list is undefined behaviour
        assert(i_array.length > 0);
        
        return searchMinimumCombinedStrategy(i_array, 0, i_array.length);
    }
    
    public static final int THRESHOLD = 10;
    
    private static int searchMinimumCombinedStrategy(int[] i_array, int index_begin, int index_end) {
        
        assert(index_begin < index_end);
        
        // Number of elements on the sub-array
        int N = index_end - index_begin;
        
        // End of recursion:
        // If the number of elements left is less than the threshold value,
        // we won't bother anymore with the divide and conquer strategy
        if (N <= SearchMinimumCombinedStrategy.THRESHOLD) {
            int current_index = 0;
            int minimum_value = Integer.MAX_VALUE;
            while (current_index < i_array.length) {
                if (minimum_value > i_array[current_index])
                    minimum_value = i_array[current_index];
                current_index++;
            }
            return minimum_value;
        }
        
        // N > THRESHOLD
        // Divide the array in two halves: compute the minimum of each sub-array, and return the minimum of both
        int H = N / 2;
        int minimum1 = searchMinimumCombinedStrategy(i_array, index_begin, index_begin + H);
        int minimum2 = searchMinimumCombinedStrategy(i_array, index_begin + H, index_end);
        return (minimum1 < minimum2) ? minimum1 : minimum2;
    }
    
    public static void main(String[] args) {
        
        int[] myArray1 = { 4, 2, 1, 3, 5 };
        int minimum1 = searchMinimum(myArray1);
        System.out.println("The lowest value is: " + minimum1 + ".");
        
        int[] myArray2 = { 461, 233, 101, 13, 55, 69, 48, 101, 77 };
        int minimum2 = searchMinimum(myArray2);
        System.out.println("The lowest value is: " + minimum2 + ".");
        
        int[] myArray3 = {
            461, 233, 101, 130, 155,  69,  48, 101,  77,
            444, 997, 151, 315, 784, 368, 987,  35, 102
        };
        int minimum3 = searchMinimum(myArray3);
        System.out.println("The lowest value is: " + minimum3 + ".");
    }
}
