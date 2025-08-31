package maximum_slice_problem;


public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.solution(new int[] {23171, 21011, 21123, 21366, 21013, 21367}));
    }

    public int solution(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        int[] profits = new int[len];
        for (int i = 1; i < len; i++) {
            profits[i] = A[i] - A[i-1];
        }

        int[] sums = new int[len];
        for (int i = 1; i < len; i++) {
            sums[i] = Math.max(sums[i-1] + profits[i], profits[i]);
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
