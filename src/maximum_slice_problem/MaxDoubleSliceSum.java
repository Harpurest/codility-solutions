package maximum_slice_problem;

public class MaxDoubleSliceSum {

    public static void main(String[] args) {
        MaxDoubleSliceSum maxDoubleSliceSum = new MaxDoubleSliceSum();
        System.out.println(maxDoubleSliceSum.solution(new int[] {3, 2, 6, -1, 4, 5, -1, 2}));
        System.out.println(maxDoubleSliceSum.solution(new int[] {0, 10, -5, -2, 0}));
    }
    
    public int solution(int[] A) {
        int len = A.length;
        int[] sumls = new int[len];
        int[] sumrs = new int[len];
        sumls[0] = 0;
        sumrs[len - 1] = 0;
        for (int i = 1; i < len; i++) {
            sumls[i] = Math.max(sumls[i-1] + A[i], A[i]);
            sumls[i] = Math.max(sumls[i], 0);
            sumrs[len - 1 - i] = Math.max(sumrs[len - 1 - i + 1]+ A[len - 1 - i], A[len - 1 - i]);
            sumrs[len - 1 - i] = Math.max(sumrs[len - 1 - i], 0);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < len - 1; i++) {
            int current;
            current = sumls[i-1] + sumrs[i+1];
            if (current > max) {
                max = current;
            }
        }
        return max;
    }
}
