package dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static dynamicprogramming.MaxSumIncreasingSubsequence.maxSumIncreasingSubsequence;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaxSumIncreasingSubsequenceTest {

    int[] arrayOne = {10, 70, 20, 30, 50, 11, 30};
    List<List<Integer>> expectedAnswerOne = Arrays.asList(Arrays.asList(110), Arrays.asList(10, 20, 30, 50));

    int[] arrayTwo = {-5, -4, -3, -2, -1};
    List<List<Integer>> expectedAnswerTwo = Arrays.asList(Arrays.asList(-1), Arrays.asList(-1));

    @Test
    public void shouldFindMaxSumIncreasingSubsequence() {
        List<List<Integer>> actualAnswer = maxSumIncreasingSubsequence(arrayOne);

        assertThat(actualAnswer, equalTo(expectedAnswerOne));

        actualAnswer = maxSumIncreasingSubsequence(arrayTwo);

        assertThat(actualAnswer, equalTo(expectedAnswerTwo));
    }
}