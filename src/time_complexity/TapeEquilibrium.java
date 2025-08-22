package time_complexity;

public class TapeEquilibrium {
    public static void main(String[] args) {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        System.out.println(tapeEquilibrium.solution(new int[]{3,1,2,4,3}));
    }

    public int solution(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        int first = A[0];
        if (len == 1) {
            return first;
        }
        int second = 0;
        for (int i = 1; i < len; i++) {
            second += A[i];
        }

        int min = Math.abs(first - second);
        for (int i = 1; i < len - 1; i++) {
            first += A[i];
            second -= A[i];
            int current = Math.abs(first - second);
            if (current < min) {
                min = current;
            }
        }

        return min;
    }
}
