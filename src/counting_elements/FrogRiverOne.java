package counting_elements;

public class FrogRiverOne {
    public static void main(String[] args) {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        int res = frogRiverOne.solution(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4});
        System.out.println(res);
    }

    public int solution(int X, int[] A) {
        // Implement your solution here
        int expectedSum = ((X + 1) * X) / 2;
        int actualSum = 0;
        int[] tracks = new int[X + 1];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > X) {
                continue;
            }
            if (tracks[A[i]] < 1) {
                tracks[A[i]] = 1;
                actualSum += A[i];
            }
            if (actualSum == expectedSum) {
                return i;
            }
        }
        return -1;
    }
}
