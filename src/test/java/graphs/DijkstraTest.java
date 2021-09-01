package graphs;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static graphs.Dijkstra.dijkstraAlgorithm;

public class DijkstraTest {

    int[][][] firstAdjacencyArray = {
            {{1, 7}},
            {{2, 6}, {3, 20}, {4, 3}},
            {{3, 14}},
            {{4, 2}},
            {},
            {}
    };

    int firstStart = 0;
    int[] firstExpected = {0, 7, 13, 27, 10, -1};

    @Test
    public void shouldReturnShortestPathsArray() {
        int[] actual = dijkstraAlgorithm(firstStart, firstAdjacencyArray);

        Arrays.stream(actual).forEach(System.out::println);
        assertThat(actual, equalTo(firstExpected));
    }
}