package dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import static dynamicprogramming.Knapsack.knapsackProblem;

public class KnapsackTest {

    int[][] itemsOne = {
            {1, 2},
            {4, 3},
            {5, 6},
            {6, 7}
    };

    int capacityOne = 10;
    List<List<Integer>> solutionOne = List.of(Arrays.asList(10), Arrays.asList(1, 3));

    int[][] itemsTwo = {
            {465, 100},
            {400, 85},
            {255, 55},
            {350, 45},
            {650, 130},
            {1000, 190},
            {455, 100},
            {100, 25},
            {1200, 190},
            {320, 65},
            {750, 100},
            {50, 45},
            {550, 65},
            {100, 50},
            {600, 70},
            {240, 40}
    };

    int capacityTwo = 200;
    List<List<Integer>> solutionTwo = List.of(Arrays.asList(1500), Arrays.asList(3, 12, 14));

    @Test
    public void shouldReturnOptimalValueAndItems() {
        List<List<Integer>> actual = knapsackProblem(itemsOne, capacityOne);

        assertThat(actual, equalTo(solutionOne));

        actual = knapsackProblem(itemsTwo, capacityTwo);

        assertThat(actual, equalTo(solutionTwo));
    }
}