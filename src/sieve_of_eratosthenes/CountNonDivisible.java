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
        countNonDivisible.printArray(countNonDivisible.solution(new int[] {1, 2, 3, 5, 6, 10, 15, 30}));
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
        int[] results = new int[len];
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

        int countDiv = 0;
        long k = 1;
        for (int i = 0; i < len; i++) {
            int target = A[i];
            countDiv = 0;
            k = 1;
            while (k * k < target) {
                if (target % k == 0) {
                    countDiv += tracks[Math.toIntExact(k)];
                    countDiv += tracks[Math.toIntExact(target / k)];
                }
                k += 1;
            }
            if (k * k == target) {
                countDiv += tracks[Math.toIntExact(k)];
            }
            results[i] = len - countDiv;
        }

        return results;
    }
}
