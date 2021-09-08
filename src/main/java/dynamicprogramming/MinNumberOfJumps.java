package dynamicprogramming;

public class MinNumberOfJumps {

    /**
     * Takes in a non-empty array of positive integers which represent the maximum number of steps to take forward
     * in the array and returns the minimum number of jumps needed to reach the final index.
     * @param array
     * @return
     */
    public static int minNumberOfJumps(int[] array) {
        if (array.length <= 1) {
            return 0;
        }

        int jumps = 0;
        int steps = array[0];
        int maxRange = array[0];

        for (int i = 0; i < array.length; i++) {
            maxRange = Math.max(maxRange, array[i] + i);
            steps--;

            if (steps == 0) {
                jumps++;
                steps = maxRange - i;
            }
        }

        return ++jumps;
    }
}
