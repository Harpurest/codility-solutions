package arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        int[] results = cyclicRotation.solution(new int[] {3, 8, 9, 7, 6}, 3);
        for (int res : results) {
            System.out.println(res);
        }
    }

    public int[] solution(int[] A, int K) {
        int len = A.length;
        int[] results = new int[len];
        for (int i = 0; i < len; i++) {
            results[(i + K) % len] = A[i];
        }

        return results;
    }
}
