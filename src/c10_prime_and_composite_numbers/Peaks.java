package c10_prime_and_composite_numbers;

import java.util.LinkedList;
import java.util.List;

public class Peaks {

    public static void main(String[] args) {
        Peaks peaks = new Peaks();
        /*
        System.out.println(peaks.solution(new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
        System.out.println(peaks.solution(new int[] {1, 3, 2, 1}));
        System.out.println(peaks.solution(new int[] {0, 1000}));
         */
        System.out.println(peaks.solution(new int[] {0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0}));
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

        int[] prefixPeaks = new int[len + 1];

        for (int i = 0; i < len; i++) {
            // Tracking peaks
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

            // Count peaks
            if (i == 0) {
                prefixPeaks[i] = 0;
            } else {
                if (peaks[i-1]) {
                    prefixPeaks[i] = prefixPeaks[i-1] + 1;
                } else {
                    prefixPeaks[i] = prefixPeaks[i-1];
                }
            }
        }
        if (peaks[len - 1]) {
            prefixPeaks[len] = prefixPeaks[len-1] + 1;
        } else {
            prefixPeaks[len] = prefixPeaks[len - 1];
        }

        if (count == 0) {
            return 0;
        }

        List<Integer> divisors = new LinkedList<Integer>();
        int div = 1;
        while (div <= count) {
            if (len % div == 0) {
                divisors.add(div);
            }
            div += 1;
        }

        Integer[] divisorsArray = divisors.toArray(Integer[]::new);
        /*
        int end = divisorsArray.length - 1;
        int start = 0;
        int target = -1;
        while (start <= end) {
            int test = (start + end) / 2;
            int testValue = divisorsArray[test];
            boolean res = check(A, prefixPeaks, testValue);
            if (res) {
                start = test + 1;
                target = test;
            } else {
                end = test - 1;
            }
        }

        if (target > -1 ) {
            return divisorsArray[target];
        }
        */
        int max = 1;
        for (int i : divisorsArray) {
            if (check(A, prefixPeaks, i)) {
                max = i;
            }
        }

        return max;
    }

    private boolean check(int[] A, int[] prefixes, int check) {
        int len = A.length;
        int space = len / check;
        for (int i = 0; i < len - space + 1; i+= space) {
            int end = i + space;
            if (prefixes[end] - prefixes[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
