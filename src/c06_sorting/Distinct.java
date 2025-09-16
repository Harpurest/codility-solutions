package c06_sorting;

import java.util.Arrays;

public class Distinct {
    public static void main(String[] args) {
        Distinct distinct = new Distinct();
        System.out.println(distinct.solution(new int[] {2, 1, 1, 2, 3, 1}));
    }

    public int solution(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(A);
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (A[i] != A[i-1]) {
                count += 1;
            }
        }

        return count;
    }
}
