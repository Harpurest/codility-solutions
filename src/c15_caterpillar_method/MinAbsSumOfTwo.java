package c15_caterpillar_method;

import java.util.Arrays;

public class MinAbsSumOfTwo {

    public static void main(String[] args) {
        MinAbsSumOfTwo minAbsSumOfTwo = new MinAbsSumOfTwo();
        int res;

        res = minAbsSumOfTwo.solution(new int[] {1, 4, -3});
        System.out.println(res);

        res = minAbsSumOfTwo.solution(new int[] {-8, 4, 5, -10, 3});
        System.out.println(res);
    }

    public int solution(int[] A) {
        int len = A.length;
        if (len == 1) {
            return Math.abs(2 * A[0]);
        }
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;

        int head = 0;
        int tail = len - 1;
        while (head <= tail) {
            int candidate = Math.abs(A[head] + A[tail]);

            if (candidate < min) {
                min = candidate;
            }
            if (Math.abs(A[head]) >= A[tail]) {
                head += 1;
            } else if (Math.abs(A[head]) < A[tail]) {
                tail -= 1;
            }
        }

        return min;
    }
}
