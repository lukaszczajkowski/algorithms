package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumIncreasingSubsequence {

    /**
     * Takes in a non-empty array of integers and returns the greatest sum that can be generated from a strictly-increasing
     * subsequence in the array along with an list of numbers in that subsequence.
     * @param array
     * @return list containing the greatest sum and the list of numbers of the subsequence generating it
     */
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[] maxSums = array.clone();
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, Integer.MIN_VALUE);

        int maxSumIdx = 0;

        for (int i = 1; i < array.length; i++) {
            int currentNum = array[i];

            for (int j = 0; j < i; j++) {
                int numToCompare = array[j];

                if (currentNum > numToCompare && currentNum + maxSums[j] >= maxSums[i]) {
                    maxSums[i] = currentNum + maxSums[j];
                    sequences[i] = j;
                }
            }

            if (maxSums[i] >= maxSums[maxSumIdx]) {
                maxSumIdx = i;
            }
        }

        return backtrackSequence(array, sequences, maxSums, maxSumIdx);
    }

    private static List<List<Integer>> backtrackSequence(int[] array, int[] sequences, int[] maxSums, int currentIdx) {
        List<List<Integer>> answer = new ArrayList<>();

        answer.add(Arrays.asList(maxSums[currentIdx]));
        answer.add(new ArrayList<>());

        while (currentIdx != Integer.MIN_VALUE) {
            answer.get(1).add(0, array[currentIdx]);
            currentIdx = sequences[currentIdx];
        }

        return answer;
    }
}
