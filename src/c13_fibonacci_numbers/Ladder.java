package c13_fibonacci_numbers;

public class Ladder {

    public static void main(String[] args) {
        Ladder ladder = new Ladder();

        int[] results = ladder.solution(
                new int[] {4,4,5,5,1},
                new int[] {3,2,4,3,1}
        );

        ladder.printArray(results);

        results = ladder.solution(
                new int[] {1},
                new int[] {1}
        );

        ladder.printArray(results);
    }

    private void printArray(int[] A) {
        int len = A.length;
        System.out.print("[ ");
        for (int i = 0; i < len; i++) {
            System.out.print(A[i] + "  ");
        }
        System.out.print("]");
        System.out.println();
    }

    public int[] solution(int[] A, int[] B) {
        int len = A.length;
        int[] results = new int[len];
        int[] fibs = new int[Math.max(3, len + 1)];
        fibs[0] = 0;
        fibs[1] = 1;
        fibs[2] = 2;

        int maxPow = 1 << 30;

        // we know that the result of a number modulo 2^P is the bit under P, so
        // if we first let the number modulo 2^Q(Q > P) and then modulo 2^P, the
        // result is the same.

        for (int i = 3; i < len + 1; i++) {
            fibs[i] = ((fibs[i-1] % maxPow) + (fibs[i-2] % maxPow)) % maxPow;
        }

        for (int i = 0; i < len; i++) {
            // make sure the fibonacci number will not exceed the max integer in java 1<<n =
            // 2^n
            // Calculating pow of 2 by shifting bit
            int pow = 1 << B[i];
            results[i] = fibs[A[i]] % pow;
        }

        return results;
    }
}
