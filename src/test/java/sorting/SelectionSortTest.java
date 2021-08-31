package sorting;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static sorting.SelectionSort.selectionSort;

public class SelectionSortTest {

    int[] arrayOne = new int[]{5, 10, 3, 2, 1, 50};

    @Test
    public void shouldSortArray() {
        selectionSort(arrayOne);

        assertThat(arrayOne, equalTo(new int[] {1, 2, 3, 5, 10, 50}));
    }
}