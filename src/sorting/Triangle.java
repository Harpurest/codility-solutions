package sorting;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        // System.out.println(triangle.solution(new int[] {10, 2, 5, 1, 8, 20}));
        System.out.println(triangle.solution(new int[] {10, 50, 5, 1}));
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        for (int i = 2; i < len; i++) {
            if (A[i] < A[i-1] + A[i-2]) {
                return 1;
            }

        }
        return 0;
    }
}
