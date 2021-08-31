package binarysearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static binarysearch.BinarySearch.binarySearch;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinarySearchTest {

    int targetOne = 3;
    int[] arrayOne = new int[] {1, 2, 3, 4, 5};
    int targetTwo = 10;
    int[] arrayTwo = new int[] {0};
    int targetThree = 1;
    int targetFour = 2;
    int[] arrayThree = new int[] {1, 2};
    int targetFive = 90;
    int targetSix = 120;
    int targetSeven = 1;
    int[] arrayFour = new int[] {1, 5, 60, 90, 120};

    @Test
    public void binarySearchTest() {
        int firstResult = binarySearch(arrayOne, targetOne);
        int secondResult = binarySearch(arrayTwo, targetTwo);
        int thirdResult = binarySearch(arrayThree, targetThree);
        int fourthResult = binarySearch(arrayThree, targetFour);
        int fifthResult = binarySearch(arrayFour, targetFive);
        int sixthResult = binarySearch(arrayFour, targetSix);
        int seventhResult = binarySearch(arrayFour, targetSeven);
        List<Integer> actualResults = new ArrayList<>(Arrays.asList(firstResult, secondResult, thirdResult, fourthResult, fifthResult,
                sixthResult, seventhResult));
        List<Integer> expectedResults = Arrays.asList(2, -1, 0, 1, 3, 4, 0);

        IntStream.range(0, actualResults.size()).boxed().forEach(i -> {
            assertThat(actualResults.get(i), equalTo(expectedResults.get(i)));
        });
    }
}