package dynamicprogramming;

import org.junit.Test;

import static dynamicprogramming.NumOfWaysToTraverseGraph.calculateWaysToTraverseGraphDp;
import static dynamicprogramming.NumOfWaysToTraverseGraph.calculateWaysToTraverseGraphMath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NumOfWaysToTraverseGraphTest {

    int height1 = 3;
    int width1 = 4;
    int answer1 = 10;

    int height2 = 5;
    int width2 = 5;
    int answer2 = 70;

    int height3 = 9;
    int width3 = 5;
    int answer3 = 495;

    int height4 = 3;
    int width4 = 3;
    int answer4 = 6;

    @Test
    public void shouldCalculateNumOfWaysUsingDp() {
        int actual = calculateWaysToTraverseGraphDp(width1, height1);

        assertThat(actual, equalTo(answer1));

        actual = calculateWaysToTraverseGraphDp(width2, height2);

        assertThat(actual, equalTo(answer2));

        actual = calculateWaysToTraverseGraphDp(width3, height3);

        assertThat(actual, equalTo(answer3));

        actual = calculateWaysToTraverseGraphDp(width4, height4);

        assertThat(actual, equalTo(answer4));
    }

    @Test
    public void shouldCalculateNumOfWaysUsingMath() {
        int actual = calculateWaysToTraverseGraphMath(width1, height1);

        assertThat(actual, equalTo(answer1));

        actual = calculateWaysToTraverseGraphMath(width2, height2);

        assertThat(actual, equalTo(answer2));

        actual = calculateWaysToTraverseGraphMath(width3, height3);

        assertThat(actual, equalTo(answer3));

        actual = calculateWaysToTraverseGraphMath(width4, height4);

        assertThat(actual, equalTo(answer4));
    }
}