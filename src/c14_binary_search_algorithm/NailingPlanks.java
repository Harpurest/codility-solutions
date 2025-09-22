package c14_binary_search_algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class NailingPlanks {

    public static void main(String[] args) {
        NailingPlanks nailingPlanks = new NailingPlanks();
        int res;
        /*
        res = nailingPlanks.solution(
            new int[] {1, 4, 5, 8},
            new int[] {4, 5, 9, 10},
            new int[] {4, 6, 7, 10, 2}
        );

        System.out.println(res);

        res = nailingPlanks.solution(
                new int[] {4, 5, 9, 10},
                new int[] {4, 5, 9, 10},
                new int[] {4, 5, 9, 10, 10, 2}
        );

        System.out.println(res);

        res = nailingPlanks.solution(
                new int[] {2},
                new int[] {2},
                new int[] {1}
        );

        System.out.println(res);

        res = nailingPlanks.solution(
                new int[] {1, 2, 10},
                new int[] {10, 11, 11},
                new int[] {1,2,3,4,5,6,7,8,9}
        );

        System.out.println(res);
         */

        res = nailingPlanks.solution(
                new int[] {1, 2, 3, 4, 5},
                new int[] {1, 2, 3, 4, 5},
                new int[] {5, 4, 3, 2, 1}
        );

        System.out.println(res);
    }

    public int solution(int[] A, int[] B, int[] C) {
        int nailsLen = C.length;
        int[][] nails = new int[nailsLen][2];
        for (int i = 0; i < nailsLen; i++) {
            nails[i][0] = C[i];
            nails[i][1] = i;
        }

        Arrays.sort(nails, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int max = -1;
        for (int i = 0; i < A.length; i++) {
            int minNailIndex = findMinIndexNail(A[i], B[i], nails, max);
            if (minNailIndex == -1) {
                return -1;
            }
            max = Math.max(max, minNailIndex);
        }

        return max + 1;
    }

    private int findMinIndexNail(int head, int tail, int[][] nails, int maxIndex) {
        int start = 0;
        int end = nails.length - 1;
        int target = -1;
        while (start <= end) {
            int check = (start + end) / 2;
            if (head > nails[check][0]) {
                start = check + 1;
            } else if (tail < nails[check][0]){
                end = check - 1;
            } else {
                // (head <= nails[check][0] && nails[check][0] <= tail)
                target = check;
                end = check - 1;
            }
        }

        if (target == -1) {
            return -1;
        }

        int nailIndex = nails[target][1];

        for (int i = target; i < nails.length; i++) {
            if (nails[i][0] > tail) {
                break;
            }
            nailIndex = Math.min(nailIndex, nails[i][1]);
            if (maxIndex != -1 && nailIndex <= maxIndex) {
                return maxIndex;
            }
        }

        return nailIndex;
    }
}
