package dynamicprogramming;

public class NumOfWaysToTraverseGraph {

    /**
     * Takes in two positive integers representing width and height of rectangular grid graph and returns the number of
     * ways to reach the bottom right corner of the graph. Starting position is top left corner. It is only possible to move
     * one square right or one square down.
     * @param width
     * @param height
     * @return
     */
    public static int calculateWaysToTraverseGraphDp(int width, int height) {
        int[][] numOfWays = new int[width + 1][height + 1];

        for (int i = 1; i < width + 1; i++) {
            for (int j = 1; j < height + 1; j++) {
                if (i == 1 || height == 1) {
                    numOfWays[i][j] = 1;
                } else {
                    numOfWays[i][j] = numOfWays[i - 1][j] + numOfWays[i][j - 1];
                }
            }
        }

        return numOfWays[width][height];
    }

    /**
     * Same as above but uses math formula for number of permutations:
     * numOfPermutations = (possibleMovementsRight + possibleMovementsDown)! / (possibleMovementsRight! * possibleMovementsDown!)
     * @param width
     * @param height
     * @return
     */
    public static int calculateWaysToTraverseGraphMath(int width, int height) {
        int possibleMovementsRight = width - 1;
        int possibleMovementsDown = height - 1;

        int numerator = factorial(possibleMovementsRight + possibleMovementsDown);
        int denominator = factorial(possibleMovementsRight) * factorial(possibleMovementsDown);
        return numerator / denominator;
    }

    private static int factorial(int number) {
        int result = 1;

        for (int i = 2; i < number + 1; i++) {
            result *= i;
        }

        return result;
    }
}
