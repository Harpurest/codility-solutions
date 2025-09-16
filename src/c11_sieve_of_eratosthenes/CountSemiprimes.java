package c11_sieve_of_eratosthenes;

public class CountSemiprimes {

    public static void main(String[] args) {
        CountSemiprimes countSemiprimes = new CountSemiprimes();
        countSemiprimes.printArray(countSemiprimes.solution(
                26,
                new int[] {1,4,16},
                new int[]{26,10,20}
        ));
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

    public int[] solution(int N, int[] P, int[] Q) {
        int[] tracks = new int[N + 1];
        int i = 2;
        while (i * i <= N) {
            int k = i * i;
            while (k <= N) {
                if (tracks[k] == 0) {
                    tracks[k] = i;
                }
                k += i;
            }
            i += 1;
        }

        boolean[] semiPrimes = new boolean[N + 1];
        for (int j = 0; j < N + 1; j++) {
            if (tracks[j] != 0
                    && (tracks[j / tracks[j]]) == 0) {
                semiPrimes[j] = true;
            }
        }

        int[] prefixSemis = new int[N + 1];
        prefixSemis[0] = 0;
        for (int j = 1; j < N + 1; j++) {
            if (semiPrimes[j-1]) {
                prefixSemis[j] = prefixSemis[j-1] + 1;
            } else {
                prefixSemis[j] = prefixSemis[j-1];
            }
        }

        int len = P.length;
        int[] results = new int[len];

        for (int j = 0; j < len; j++) {
            int start = P[j];
            int end = Q[j];
            results[j] = prefixSemis[end] - prefixSemis[start];
            if (semiPrimes[end]) {
                results[j] += 1;
            }
        }

        return results;
    }
}
