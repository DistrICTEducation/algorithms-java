package fundamentals;

public class SearchMinimum {

    public static void main(String[] args) {

        // The input data is a sequence of numbers
        int[] myArray = { 4, 2, 1, 3, 5 };

        // The index of the first element is 0 (and index of the last element is 4)
        int current_index = 0;

        // Since we are looking for the lowest value, we initialise the starting value at
        // postive infinity, so the first comparison will always be true, placing the value
        // at index 0 in minimum_value
        int minimum_value = Integer.MAX_VALUE;

        // Since the length is 5 and the highest index is 4, we will loop through each element
        // by increasing the current_index by 1 on each iteration and stopping the loop as
        // soon as the current_index reaches 5 (then the condition is no longer true that
        // is keeping the loop "alive").
        while (current_index < myArray.length) {

            // Assume that each iteration adds more information: hence each time we
            // see a new number, we must check if it actually lower than any number
            // we know so far. If it is, then update our information.
            if (minimum_value > myArray[current_index]) {
                minimum_value = myArray[current_index];
            }

            // Increase the index at the end of the iteration (otherwise the index 0
            // won't be used for the first element, but index 1.)
            current_index++;
        }

        // Finally, print the output to the console!
        System.out.println("The lowest value is: " + minimum_value + ".");
    }
}
