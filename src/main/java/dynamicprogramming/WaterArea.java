package dynamicprogramming;

public class WaterArea {

    /**
     * Takes in an array of non-negative integers where each integer represents the height of a pillar of width 1 and
     * returns the area of the water between the pillars viewed from the front - spilled water is ignored.
     * @param heights
     * @return
     */
    public static int calculateArea(int[] heights) {
        if (heights.length <= 2) {
            return 0;
        }

        int area = 0;
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        int leftMax = heights[leftPointer];
        int rightMax = heights[rightPointer];

        while (leftPointer < rightPointer) {
            if (heights[leftPointer] > heights[rightPointer]) {
                rightPointer --;
                rightMax = Math.max(heights[rightPointer], rightMax);
                area += rightMax - heights[rightPointer];
            } else {
                leftPointer ++;
                leftMax = Math.max(heights[leftPointer], leftMax);
                area += leftMax - heights[leftPointer];
            }
        }

        return area;
    }
}
