package fundamentals;

public class SearchMinimumDivideAndConquer {
    
    public static int searchMinimum(int[] i_array) {
        
        // Finding the lowest value of an empty list is undefined behaviour
        assert(i_array.length > 0);
        
        return searchMinimumDivideAndConquer(i_array);
    }
    
    private static int searchMinimumDivideAndConquer(int[] i_array) {
        
        // Keep N as the array length (less verbose)
        int N = i_array.length;
        
        // End of recursion (trivial case)
        if (N == 1) {
            return i_array[0];
        }
        
        // End of recursion
        if (N == 2) {
            return (i_array[0] < i_array[1]) ? i_array[0] : i_array[1];
        }
        
        // N > 2
        // Divide the array in two halves: compute the minimum of each sub-array, and return the minimum of both
        int H = N / 2;
        int minimum1 = searchMinimumDivideAndConquer(java.util.Arrays.copyOfRange(i_array, 0, H));
        int minimum2 = searchMinimumDivideAndConquer(java.util.Arrays.copyOfRange(i_array, H, N));
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
