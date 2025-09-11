package sieve_of_eratosthenes;

import java.util.HashSet;
import java.util.Set;

public class CountNonDivisible {

    public static void main(String[] args) {
        CountNonDivisible countNonDivisible = new CountNonDivisible();
        countNonDivisible.printArray(countNonDivisible.solution(new int[] {3, 1, 2, 3, 6}));
        countNonDivisible.printArray(countNonDivisible.solution(new int[] {2, 4}));
        countNonDivisible.printArray(countNonDivisible.solution(new int[] {1, 2, 4, 8, 16}));
        countNonDivisible.printArray(countNonDivisible.solution(new int[] {3, 9, 27, 36 }));
        countNonDivisible.printArray(countNonDivisible.solution(new int[] {3, 1, 2, 3, 4, 12}));
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

    // Break time constraint
    public int[] wrongSolution(int[] A) {
        int len = A.length;
        int max = A[0];

        for (int i = 1; i < len; i++) {
            if(A[i] > max) {
                max = A[i];
            }
        }

        int[] counts = new int[max + 1];
        for (int i = 0; i < len; i++) {
            int step = A[i];
            int current = step * step;
            while(current <= max) {
                counts[current] += 1;
                current += step;
            }
        }

        int[] results = new int[len];
        for (int j = 0; j < len; j++) {
            results[j] = len - counts[A[j]];
        }

        return results;
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
        Set<Integer> countSet = new HashSet<>();

        for (int j = 0; j < len; j++) {
            int target = A[j];

            if (target == 1) {
                results[j] = len - tracks[target];
                continue;
            }

            // Fix the case [3, 1, 2, 3, 4, 12] espaccially number 12
            int trackingReverse = 1;

            while (divs[target] > 0) {
                countSet.add(target);
                countSet.add(divs[target]);
                countSet.add(trackingReverse);

                trackingReverse *= divs[target];
                target /= divs[target];
            }

            countSet.add(target);
            countSet.add(trackingReverse);

            for (int count : countSet) {
                results[j] += tracks[count];
            }
            results[j] = len - results[j];

            countSet.clear();
        }

        return results;
    }
}
