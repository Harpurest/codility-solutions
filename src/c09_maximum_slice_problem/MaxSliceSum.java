package c09_maximum_slice_problem;

public class MaxSliceSum {

    public static void main(String[] args) {
        MaxSliceSum maxSliceSum = new MaxSliceSum();
        System.out.println(maxSliceSum.solution(new int[] {3, 2, -6, 4, 0}));
    }

    public int solution(int[] A) {
        int len = A.length;
        int[] sums = new int[len];
        sums[0] = A[0];
        for (int i = 1; i < len; i++) {
            sums[i] = Math.max(sums[i-1] + A[i], A[i]);
        }
        int max = sums[0];
        for (int i = 0; i < len; i++) {
            if (sums[i] > max) {
                max = sums[i];
            }
        }

        return max;
    }
}
