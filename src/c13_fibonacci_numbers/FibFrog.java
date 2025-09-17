package c13_fibonacci_numbers;

public class FibFrog {
    public static void main(String[] args) {
        FibFrog fibFrog = new FibFrog();
        System.out.println(fibFrog.solution(
                new int[] {0,0,0,1,1,0,1,0,0,0,0}));
        System.out.println(fibFrog.solution(
                new int[] {}));
        System.out.println(fibFrog.solution(
                new int[] {0,0}));
    }

    public int solution(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 1;
        }
        int fibsLen = Math.max(5, len + 1);
        int[] fibs = new int[fibsLen];
        fibs[0] = 0;
        fibs[1] = 1;
        int count = 2;
        for (int i = 2; i < fibsLen; i++) {
            fibs[i] = fibs[i-1] + fibs[i-2];
            count += 1;
            if (fibs[i] > len + 1) {
                break;
            }
        }

        int[] tracks = new int[len + 1];
        for (int i = 0; i < len + 1; i++) {
            if (i < len && A[i] == 0) {
                continue;
            }
            for (int j = 1; j < count; j++) {
                int prev = i - fibs[j];
                if (prev == -1) {
                    tracks[i] = 1;
                } else if (prev < -1) {
                    break;
                } else if (A[prev] == 1 && tracks[prev] > 0) {
                    if(tracks[i] == 0) {
                        tracks[i] = tracks[prev] + 1;
                    } else {
                        tracks[i] = Math.min(tracks[i], tracks[prev] + 1);
                    }
                }
            }
        }

        return tracks[len] <= 0 ? -1 : tracks[len];
    }
}
