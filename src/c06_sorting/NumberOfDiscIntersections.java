package c06_sorting;

import java.util.Arrays;
import java.util.Comparator;

public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        NumberOfDiscIntersections numberOfDiscIntersections = new NumberOfDiscIntersections();
        // System.out.println(numberOfDiscIntersections.solution(new int[] {1, 5, 2, 1, 4, 0}));
        System.out.println(numberOfDiscIntersections.solution(new int[] {1, 2147483647, 0}));
    }

    public int solution(int[] A) {
        int len = A.length;
        long[][] ranges = new long[len][2];
        for (int i = 0; i < len; i++) {
            ranges[i][0] = (long)i - (long)A[i];
            ranges[i][1] = (long)i + (long)A[i];
        }
        int count = 0;

        Arrays.sort(ranges, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < len; i++) {
            int start = i + 1;
            int end = len - 1;
            int target = -1;
            while (start <= end) {
                int test = (start + end) / 2;
                if (ranges[test][0] <= ranges[i][1]) {
                    target = test;
                    start = test + 1;
                } else {
                    end = test - 1;
                }
            }
            if (target > -1) {
                count += target - i;
            }
        }

        if (count > 10000000) {
            return -1;
        }

        return count;
    }
}
