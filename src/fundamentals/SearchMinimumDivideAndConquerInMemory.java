package fundamentals;


/**
 * Implementation for searching the minimum value in an array of integers.
 * In this case, we gradually look at smaller groups of elements within the array. When we arrive at the smallest number
 * of elements to compare (either 1 or 2 elements of a sub-array), we return the lowest value and gradually work our way
 * back to the initial point of the recursive stack, which should yield the overal lowest number.
 * The array is not copied as a sub-array, instead we keep track of the begin and end indices of each sub-array. This way
 * we avoid some array copy overhead.
 * 
 * @author  Joris Schelfaut
 * @version 1.0.0
 * @since   1.0.0
 */
public class SearchMinimumDivideAndConquerInMemory {
    
    public static int searchMinimum(int[] i_array) {
        
        // Finding the lowest value of an empty list is undefined behaviour
        assert(i_array.length > 0);
        
        return searchMinimumDivideAndConquerInMemory(i_array, 0, i_array.length);
    }
    
    private static int searchMinimumDivideAndConquerInMemory(int[] i_array, int index_begin, int index_end) {
        
        assert(index_begin < index_end);
        
        // Number of elements on the sub-array
        int N = index_end - index_begin;
        
        // End of recursion (trivial case: there is only 1 element left)
        if (N == 1) return i_array[index_begin];
        
        // N > 2
        // Divide the array in two halves: compute the minimum of each sub-array, and return the minimum of both
        int H = N / 2;
        int minimum1 = searchMinimumDivideAndConquerInMemory(i_array, index_begin, index_begin + H);
        int minimum2 = searchMinimumDivideAndConquerInMemory(i_array, index_begin + H, index_end);
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
