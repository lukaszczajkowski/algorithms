package dynamicprogramming;

import java.util.Arrays;

public class MinCoinsToMakeChange {

    /**
     * Takes in a sum of money and an array of denoms and returns a minimal number of coins that have to be used to make
     * changed for the sum. If it is impossible to make a change returns -1
     * @param sum
     * @param denoms
     * @return
     */
    public static int minCoinsToMakeChange(int sum, int[] denoms) {
        int[] minCoins = new int[sum + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0;

        int toCompare = 0;
        for (int denom : denoms) {
            for (int amount = denom; amount < sum + 1; amount++) {
                int previousMinCoins = minCoins[amount - denom];

                if (previousMinCoins == Integer.MAX_VALUE) {
                    toCompare = previousMinCoins;
                } else {
                    toCompare = previousMinCoins + 1;
                }

                minCoins[amount] = Math.min(toCompare, minCoins[amount]);
            }
        }

        return minCoins[sum] == Integer.MAX_VALUE ? -1 : minCoins[sum];
    }
}
