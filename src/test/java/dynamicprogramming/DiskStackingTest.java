package dynamicprogramming;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dynamicprogramming.DiskStacking.diskStacking;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiskStackingTest {

    List<Integer[]> disks1 = Arrays.asList(
            new Integer[] {2, 1, 2},
            new Integer[] {3, 2, 3},
            new Integer[] {2, 2, 8},
            new Integer[] {2, 3, 4},
            new Integer[] {1, 3, 1},
            new Integer[] {4, 4, 5}
    );
    List<Integer[]> answer1 = Arrays.asList(
            new Integer[] {2, 1, 2},
            new Integer[] {3, 2, 3},
            new Integer[] {4, 4, 5}
    );

    List<Integer[]> disks2 = new ArrayList<>();
    List<Integer[]> answer2 = new ArrayList<>();

    List<Integer[]> disks3 = Arrays.asList(
            new Integer[] {2, 1, 2},
            new Integer[] {3, 2, 3},
            new Integer[] {2, 3, 4}
    );

    List<Integer[]> answer3 = Arrays.asList(
            new Integer[] {2, 1, 2},
            new Integer[] {3, 2, 3}
    );

    @Before
    public void setUp() throws Exception {
        disks2.add(new Integer[] {2, 1, 2});
        answer2.add(new Integer[] {2, 1, 2});
    }

    @Test
    public void shouldCalculateDiskStacking() {
        List<Integer[]> actual = diskStacking(disks1);

        actual.forEach(array -> answer1.forEach(ans -> assertThat(array, equalTo(ans))));

        actual = diskStacking(disks2);

        actual.forEach(array -> answer2.forEach(ans -> assertThat(array, equalTo(ans))));

        actual = diskStacking(disks3);

        actual.forEach(array -> answer3.forEach(ans -> assertThat(array, equalTo(ans))));
    }
}