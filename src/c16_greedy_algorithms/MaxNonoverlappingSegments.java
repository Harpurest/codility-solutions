package c16_greedy_algorithms;

public class MaxNonoverlappingSegments {

    public static void main(String[] args) {
        MaxNonoverlappingSegments maxNonoverlappingSegments = new MaxNonoverlappingSegments();
        int res;
        res = maxNonoverlappingSegments.solution(
                new int[] {1, 3, 7, 9, 9},
                new int[] {5, 6, 8, 9, 10}
        );

        System.out.println(res);
    }

    public int solution(int[] A, int[] B) {
        int len = A.length;
        int count = 0;
        int lastStart = -1;
        int lastEnd = -1;
        for (int i = 0; i < len; i++) {
            if (A[i] > lastEnd) {
                count += 1;
                lastStart = A[i];
                lastEnd = B[i];
            } else {
                if(B[i] < lastEnd) {
                    lastStart = A[i];
                    lastEnd = B[i];
                }
            }
        }
        return count;
    }
}
