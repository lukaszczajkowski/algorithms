package dynamicprogramming;

import org.junit.Test;

import static dynamicprogramming.MaxSubsetSumNoAdjacent.maxSubsetSumNoAdjacent;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaxSubsetSumNoAdjacentTest {

    int[] array1 = {75, 105, 120, 75, 90, 135};
    int answer1 = 330;

    int[] array2 = {1};
    int answer2 = 1;

    int[] array3 = {1, 2, 3};
    int answer3 = 4;

    int[] array4 = {30, 25, 50, 55, 100, 120};
    int answer4 = 205;

    @Test
    public void shouldCalculateMaxSubsetSumNoAdjacent() {
        int actual = maxSubsetSumNoAdjacent(array1);

        assertThat(actual, equalTo(answer1));

        actual = maxSubsetSumNoAdjacent(array2);

        assertThat(actual, equalTo(answer2));

        actual = maxSubsetSumNoAdjacent(array3);

        assertThat(actual, equalTo(answer3));

        actual = maxSubsetSumNoAdjacent(array4);

        assertThat(actual, equalTo(answer4));
    }
}