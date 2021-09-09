package dynamicprogramming;

public class MaxSubsetSumNoAdjacent {

    /**
     * Takes in an array of positive integers and returns the max sum of non-adjacent elements in the array.
     * For empty array, returns 0;
     * @param array
     * @return
     */
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        int previousMaxSum = Math.max(array[0], array[1]);
        int secondPreviousMaxSum = array[0];

        for (int i = 2; i < array.length; i++) {
            int current = Math.max(previousMaxSum, secondPreviousMaxSum + array[i]);
            secondPreviousMaxSum = previousMaxSum;
            previousMaxSum = current;
        }

        return previousMaxSum;
    }
}
