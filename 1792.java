import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] singleClass : classes) {
            double gain = calculateGain(singleClass[0], singleClass[1]);
            maxHeap.offer(new double[] { gain, singleClass[0], singleClass[1] });
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] currentMax = maxHeap.poll();
            int newPass = (int) currentMax[1] + 1;
            int newSize = (int) currentMax[2] + 1;
            double newGain = calculateGain(newPass, newSize);
            maxHeap.offer(new double[] { newGain, newPass, newSize });
        }

        double sum = 0;
        for (int i = 0; i < classes.length; i++) {
            double[] singleClass = maxHeap.poll();
            sum += singleClass[1] / singleClass[2];
        }

        return sum / classes.length;
    }

    private double calculateGain(int pass, int total) {
        return (double) (pass + 1) / (total + 1) - (double) pass / total;
    }
}
