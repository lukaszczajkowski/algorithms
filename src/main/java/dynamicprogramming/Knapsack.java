package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {

    /**
     * Given an array of items (eg. [[1, 2], [4, 3]) where index is the number of the item,
     * items[i][0] is the item's value,  items[i][1] is the item's weight and the knapsack's capacity
     * it returns the total price and the indexes of the items that need to be stolen to maximize the profit
     */
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int knapsack[][] = new int[items.length + 1][capacity + 1];

        for (int item = 1; item < items.length + 1; item++) {
            int currentValue = items[item - 1][0];
            int currentWeight = items[item - 1][1];

            for (int c = 1; c < capacity + 1; c++) {
                if (currentWeight > c) {
                    knapsack[item][c] = knapsack[item - 1][c];
                } else {
                    int potentialLoot = currentValue + knapsack[item - 1][c - currentWeight];
                    knapsack[item][c] = Math.max(knapsack[item - 1][c], potentialLoot);
                }
            }
        }

        return backtrackItems(items, knapsack, knapsack[items.length][capacity]);
    }

    private static List<List<Integer>> backtrackItems(int[][] items, int[][] knapsack, int maxProfit) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(Arrays.asList(maxProfit));
        answer.add(new ArrayList<>());

        int item = knapsack.length - 1;
        int c = knapsack[0].length - 1;

        while (item > 0) {
            if (knapsack[item][c] != knapsack[item - 1][c]) {
                answer.get(1).add(0, item - 1);
                c -= items[item - 1][1];
            }
            item --;

            if (c == 0) {
                break;
            }
        }

        return answer;
    }
}