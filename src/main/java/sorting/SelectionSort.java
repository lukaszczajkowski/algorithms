package sorting;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }

            if (i != minIdx) {
                swapNums(array, i, minIdx);
            }
        }

        return array;
    }

    private static void swapNums(int[] array, int i, int minIdx) {
        int temp = array[i];
        array[i] = array[minIdx];
        array[minIdx] = temp;
    }
}
