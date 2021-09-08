package dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static dynamicprogramming.LongestCommonSubsequence.longestCommonSubsequence;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LongestCommonSubsequenceTest {

    String str1test1 = "ZXVVYZW";
    String str2test1 = "XKYKZPW";
    List<Character> test1expected = Arrays.asList('X', 'Y', 'Z', 'W');

    String str1test2 = "ABCDEFG";
    String str2test2 = "APPLES";
    List<Character> test2expected = Arrays.asList('A', 'E');

    @Test
    public void shouldFindLongestCommonSubsequence() {
        List<Character> actual = longestCommonSubsequence(str1test1, str2test1);

        assertThat(actual, equalTo(test1expected));

        actual = longestCommonSubsequence(str1test2, str2test2);

        assertThat(actual, equalTo(test2expected));
    }
}