package c17_dynamic_programming;

import java.util.Arrays;

public class MinAbsSum {

    public static void main(String[] args) {
        MinAbsSum minAbsSum = new MinAbsSum();
        int res;

        res = minAbsSum.solution(new int[] {1, 5, 2, -2});
        System.out.println(res);

        res = minAbsSum.solution(new int[] {3, 3, 3, 4, 5});
        System.out.println(res);
    }

    public int solution(int[] A) {
        // main idea:
        // using "dynamic programming" to build up the solution
        // (bottom up)
        if (A.length == 0)
            return 0;
        if (A.length == 1)
            return A[0];

        int sum = 0;
        int max = A[0];

        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
            sum += A[i];
            max = Math.max(A[i], max);
        }

        int[] count = new int[max + 1];
        for (int num : A) {
            count[num]++;
        }

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 0; i <= max; i++) {
            if (count[i] > 0) {
                for (int val = 0; val <= sum; val++) {
                    if (dp[val] >= 0)
                        dp[val] = count[i];
                    else if (val >= i && dp[val - i] > 0) {
                        dp[val] = dp[val - i] - 1;
                    }
                }
            }
        }

        int result = sum;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[i] >= 0)
                result = Math.min(result, sum - (2 * i));
        }
        return result;
    }
}
