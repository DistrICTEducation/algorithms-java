package fundamentals;

public class SearchMinimumMethod {

    public static int searchMinimum(int[] i_array) {
        int current_index = 0;
        int minimum_value = Integer.MAX_VALUE;

        while (current_index < i_array.length) {
            if (minimum_value > i_array[current_index])
                minimum_value = i_array[current_index];
            current_index++;
        }

        // Instead of
        return minimum_value;
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
