package c17_dynamic_programming;

public class NumberSolitaire {

    public static void main(String[] args) {
        NumberSolitaire numberSolitaire = new NumberSolitaire();
        int res;

        res = numberSolitaire.solution(new int[] {1, -2, 0, 9, -1, -2});
        System.out.println(res);

        res = numberSolitaire.solution(new int[] {-2, 5, 1});
        System.out.println(res);
    }

    public int solution(int[] A) {
        int len = A.length;
        int[] maxes = new int[len];
        maxes[0] = A[0];

        for (int i = 1; i < len; i++) {
            int max;
            if (i < 6) {
                max = A[i] + maxes[0];
            } else {
                max = A[i] + maxes[i - 6];
            }
            for (int j = 1; j <= 6; j++) {
                if (i - j < 0) {
                    break;
                }
                max = Math.max(max, A[i] + maxes[i-j]);
            }
            maxes[i] = max;
        }

        return maxes[len - 1];
    }
}
