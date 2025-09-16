package c05_prefix_sums;

public class PassingCars {

    public static void main(String[] args) {
        PassingCars passingCars = new PassingCars();
        System.out.println(passingCars.solution(new int[] {0, 1, 0, 1, 1}));
    }

    public int solution(int[] A) {
        int eastCount = 0;
        int pairCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                eastCount += 1;
            } else {
                pairCount += eastCount;
                if (pairCount >  1000000000) {
                    return -1;
                }
            }
        }
        return pairCount;
    }
}
