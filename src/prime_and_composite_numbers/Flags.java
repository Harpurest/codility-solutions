package prime_and_composite_numbers;

public class Flags {

    public static void main(String[] args) {
        Flags flags = new Flags();
        // System.out.println(flags.solution(new int[] {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
        System.out.println(flags.solution(new int[] {1, 3, 2}));
    }

    public int solution(int[] A) {
        int len = A.length;

        if (len == 1) {
            return 0;
        }

        if (len == 0) {
            return 0;
        }

        boolean[] peaks = new boolean[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                peaks[i] = false;
            } else if (i == len - 1) {
                peaks[i] = false;
            } else {
                if (A[i] > A[i-1] && A[i] > A[i+1]) {
                    peaks[i] = true;
                    count += 1;
                } else {
                    peaks[i] = false;
                }
            }
        }

        int end = count;
        int start = 0;
        int target = -1;
        while (start <= end) {
            int test = (start + end) / 2;
            boolean result = check(A, peaks, test);
            if (result) {
                target = test;
                start = test + 1;
            } else {
                end = test - 1;
            }
        }
        if (target > -1) {
            return target;
        }

        return 0;
    }

    private boolean check(int[] A, boolean[] tracks, int test) {
        int count = 0;
        int current = -1;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (tracks[i]) {
                if (current == -1) {
                    current = i;
                    count += 1;
                } else {
                    if (i - current >= test) {
                        count += 1;
                        current = i;
                    }
                }
            }
        }
        return count >= test;
    }
}
