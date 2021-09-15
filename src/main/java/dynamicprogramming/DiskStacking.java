package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DiskStacking {

    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        disks.sort(Comparator.comparing(disk -> disk[2]));

        int[] heights = new int[disks.size()];
        int[] sequences = new int[disks.size()];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = disks.get(i)[2];
        }

        Arrays.fill(sequences, Integer.MIN_VALUE);

        int maxHeightIdx = 0;

        for (int i = 1; i < disks.size(); i++) {
            Integer[] currentDisk = disks.get(i);

            for (int j = 0; j < i; j++) {
                Integer[] otherDisk = disks.get(j);

                if (canFitUnder(currentDisk, otherDisk)) {
                    if (heights[i] <= currentDisk[2] + heights[j]) {
                        heights[i] = currentDisk[2] + heights[j];
                        sequences[i] = j;
                    }
                }
            }

            if (heights[i] >= heights[maxHeightIdx]) {
                maxHeightIdx = i;
            }
        }

        return backtrackDisks(disks, sequences, maxHeightIdx);
    }

    private static List<Integer[]> backtrackDisks(List<Integer[]> disks, int[] sequences, int currentIdx) {
        List<Integer[]> answer = new ArrayList<>();

        while (currentIdx != Integer.MIN_VALUE) {
            answer.add(0, disks.get(currentIdx));
            currentIdx = sequences[currentIdx];
        }

        return answer;
    }

    private static boolean canFitUnder(Integer[] currentDisk, Integer[] otherDisk) {
        return currentDisk[0] > otherDisk[0] && currentDisk[1] > otherDisk[1] && currentDisk[2] > otherDisk[2];
    }
}
