package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    /**
     * Takes two strings and returns their longest common subsequence
     * @param str1
     * @param str2
     * @return
     */
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        String big = str1.length() >= str2.length() ? str1 : str2;
        String small = big.equals(str1) ? str2 : str1;

        int[][] lengths = new int[big.length() + 1][small.length() + 1];

        for (int i = 1; i < big.length() + 1; i++) {
            char currentChar = big.charAt(i - 1);

            for (int j = 1; j < small.length() + 1; j++) {
                char otherChar = small.charAt(j - 1);

                if (currentChar == otherChar) {
                    lengths[i][j] = lengths[i - 1][j - 1] + 1;
                } else {
                    lengths[i][j] = Math.max(lengths[i - 1][j], lengths[i][j - 1]);
                }
            }
        }

        return backtrackCharacters(lengths, small);
    }

    private static List<Character> backtrackCharacters(int[][] lengths, String small) {
        List<Character> answer = new ArrayList<>();

        int i = lengths.length - 1;
        int j = lengths[0].length - 1;

        while (i > 0 && j > 0) {
            if (lengths[i - 1][j] == lengths[i][j]) {
                i--;
            } else if (lengths[i][j - 1] == lengths[i][j]) {
                j--;
            } else {
                answer.add(0, small.charAt(j - 1));
                i--;
                j--;
            }

            if (lengths[i][j] == 0) {
                break;
            }
        }

        return answer;
    }
}
