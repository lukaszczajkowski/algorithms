package dynamicprogramming;

import org.junit.Test;

import static dynamicprogramming.MinCoinsToMakeChange.minCoinsToMakeChange;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinCoinsToMakeChangeTest {

    int sum1 = 7;
    int[] denoms1 = {1, 5, 10};
    int answer1 = 3;

    int sum2 = 7;
    int[] denoms2 = {2, 4};
    int answer2 = -1;

    int sum3 = 7;
    int[] denoms3 = {1, 5, 10};
    int answer3 = 3;

    @Test
    public void shouldCalculateMinCoinsToMakeChange() {
        int actual = minCoinsToMakeChange(sum1, denoms1);

        assertThat(actual, equalTo(answer1));

        actual = minCoinsToMakeChange(sum2, denoms2);

        assertThat(actual, equalTo(answer2));

        actual = minCoinsToMakeChange(sum3, denoms3);

        assertThat(actual, equalTo(answer3));
    }
}