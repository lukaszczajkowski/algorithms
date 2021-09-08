package dynamicprogramming;

import org.junit.Test;

import static dynamicprogramming.MinNumberOfJumps.minNumberOfJumps;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinNumberOfJumpsTest {

    int[] array1 = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
    int result1 = 4;

    @Test
    public void shouldReturnMinNumberOfJumps() {
        int actual = minNumberOfJumps(array1);

        assertThat(actual, equalTo(result1));
    }
}