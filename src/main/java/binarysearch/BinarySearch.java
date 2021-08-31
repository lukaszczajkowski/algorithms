package binarysearch;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        if (array.length == 0) {
            return - 1;
        }

        if (array.length == 1) {
            return array[0] == target ? 0 : -1;
        }

        int left = 0;
        int middle = array.length / 2;
        int right = array.length - 1;
        return binarySearchHelper(array, left, middle, right, target);
    }

    private static int binarySearchHelper(int[] array, int left, int middle, int right, int target) {
        if (target == array[middle]) {
            return middle;
        }

        if (left == right) {
            return -1;
        }

        if (target > array[middle]) {
            left = middle + 1;
        } else if (target < array[middle]) {
            right = middle - 1;
        }

        middle = (right + left) / 2;
        return binarySearchHelper(array, left, middle, right, target);
    }
}
