package c06_sorting;

import java.util.Arrays;

public class MaxProductOfThree {
    public static void main(String[] args) {
        MaxProductOfThree maxProductOfThree = new MaxProductOfThree();
        System.out.println(maxProductOfThree.solution(new int[] {-3 ,1, 2, -2, 5 ,6}));
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        int max =  A[len-1] * A[len-2] * A[len-3];
        if (A[0] < 0 && A[1] < 0 && A[len - 1] > 0) {
            int potential = A[0] * A[1] * A[len - 1];
            if (potential > max) {
                max = potential;
            }
        }
        return max;
    }
}
