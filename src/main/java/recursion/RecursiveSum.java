package recursion;

import java.util.List;

public class RecursiveSum {

    public static int recursiveSum(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        return recursiveSumHelper(list, list.size() - 1);
    }

    private static int recursiveSumHelper(List<Integer> list, int currentIndex) {
        if (currentIndex == 0) {
            return list.get(currentIndex);
        }

        return list.get(currentIndex) + recursiveSumHelper(list, currentIndex - 1);
    }
}
