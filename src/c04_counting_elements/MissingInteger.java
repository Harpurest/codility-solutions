package c04_counting_elements;

public class MissingInteger {

    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
        System.out.println(missingInteger.solution(new int[] {1,3,6,4,1,2}));
    }

    public int solution(int[] A) {
        int[] tracks = new int[1000001];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                if (A[i] > max) {
                    max = A[i];
                }
                tracks[A[i]] = 1;
            }
        }

        if (max == 0) {
            return 1;
        }
        for (int i = 1; i <= max; i++) {
            if(tracks[i] < 1) {
                return i;
            }
        }
        return max+1;
    }
}
