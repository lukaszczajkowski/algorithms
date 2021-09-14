package dynamicprogramming;

import org.junit.Test;

import static dynamicprogramming.WaterArea.calculateArea;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WaterAreaTest {

    int[] heights1 = {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
    int ans1 = 48;

    int[] heights2 = {0, 1, 1, 0, 0};
    int ans2 = 0;

    int[] heights3 = {0, 1, 2, 1, 1};
    int ans3 = 0;

    int[] heights4 = {0, 1, 0, 1, 0};
    int ans4 = 1;

    int[] heights5 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    int ans5 = 19;

    @Test
    public void shouldCalculateArea() {
        int actual = calculateArea(heights1);

        assertThat(actual, equalTo(ans1));

        actual = calculateArea(heights2);

        assertThat(actual, equalTo(ans2));

        actual = calculateArea(heights3);

        assertThat(actual, equalTo(ans3));

        actual = calculateArea(heights4);

        assertThat(actual, equalTo(ans4));

        actual = calculateArea(heights5);

        assertThat(actual, equalTo(ans5));
    }
}