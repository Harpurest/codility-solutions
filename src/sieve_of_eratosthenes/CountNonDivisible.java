package sieve_of_eratosthenes;

public class CountNonDivisible {

    public static void main(String[] args) {
        CountNonDivisible countNonDivisible = new CountNonDivisible();
        countNonDivisible.printArray(countNonDivisible.solution(new int[] {3, 1, 2, 3, 6}));
        countNonDivisible.printArray(countNonDivisible.solution(new int[] {2, 4}));
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

    public int[] solution(int[] A) {
        int len = A.length;
        int max = A[0];

        for (int i = 1; i < len; i++) {
            if(A[i] > max) {
                max = A[i];
            }
        }

        int[] tracks = new int[max + 1];

        for (int i = 0; i < len; i++) {
            tracks[A[i]] += 1;
        }

        int[] divs = new int[max + 1];
        int i = 2;

        while (i * i <= max) {
            if (divs[i] == 0) {
                int k = i * i;
                while (k <= max) {
                    if(divs[k] == 0) {
                        divs[k] = i;
                    }

                    k += i;
                }
            }

            i += 1;
        }

        int[] results = new int[len];

        for (int j = 0; j < len; j++) {
            int target = A[j];
            while (divs[target] > 0) {
                results[j] += tracks[target];
                results[j] += tracks[divs[target]];
                int newTarget = target / divs[target];
                // Root squared case
                if (newTarget == divs[target]) {
                    results[j] -= tracks[divs[target]];
                }
                target = newTarget;
            }
            if (A[j] != 1) {
                results[j] += tracks[target] + tracks[1];
            } else {
                results[j] += tracks[target];
            }
        }

        for (int j = 0; j < len; j++) {
            results[j] = len - results[j];
        }

        return results;
    }
}
