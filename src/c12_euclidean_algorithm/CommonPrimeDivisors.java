package c12_euclidean_algorithm;

import java.util.HashSet;
import java.util.Set;

public class CommonPrimeDivisors {

    public static void main(String[] args) {
        CommonPrimeDivisors commonPrimeDivisors = new CommonPrimeDivisors();

        System.out.println(
                commonPrimeDivisors.solution(
                        new int[] {15, 10, 9},
                        new int[] {75, 30, 5}
                )
        );


        System.out.println(
                commonPrimeDivisors.solution(
                        new int[] {135},
                        new int[] {375}
                )
        );
    }

    public int solution(int[] A, int[] B) {
        int len = A.length;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int big, small;
            if (A[i] >= B[i]) {
                big = A[i];
                small = B[i];
            } else {
                big = B[i];
                small = A[i];
            }

            int bcd = bcd(big, small);

            int newBig = big / bcd;
            int newSmall = small / bcd;

            while (true) {
                int newBcd = newBig >= bcd ? bcd(newBig, bcd) : bcd(bcd, newBig);
                if (newBcd == 1) {
                    break;
                }
                while (newBig % newBcd == 0) {
                    newBig /= newBcd;
                }
            }

            while (true) {
                int newBcd = newSmall >= bcd ? bcd(newSmall, bcd) : bcd(bcd, newSmall);
                if (newBcd == 1) {
                    break;
                }
                while (newSmall % newBcd == 0) {
                    newSmall /= newBcd;
                }
            }

            if (newBig == newSmall) {
                count += 1;
            }
        }

        return count;
    }

    private int bcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return bcd(b, a % b);
        }
    }
}
