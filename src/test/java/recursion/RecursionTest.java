package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static recursion.Recursion.elementsCount;
import static recursion.Recursion.recursiveSum;

public class RecursionTest {

    List<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

    @Test
    public void shouldSumListNums() {
        int actual = recursiveSum(listOne);

        assertThat(actual, equalTo(10));
        assertThat(recursiveSum(Collections.emptyList()), equalTo(0));
    }

    @Test
    public void shouldCountItems() {
        int actual = elementsCount(listOne);

        assertThat(actual, equalTo(4));
        assertThat(elementsCount(Collections.emptyList()), equalTo(0));

    }
}