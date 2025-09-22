package c14_binary_search_algorithm;

public class MinMaxDivision {

    public static void main(String[] args) {
        MinMaxDivision minMaxDivision = new MinMaxDivision();
        int result = minMaxDivision.solution(3, 5, new int[] {2, 1, 5, 1, 2, 2, 2});
        System.out.println(result);
    }

    public int solution(int K, int M, int[] A) {
        int len = A.length;
        int minSum = A[0]; // max of the array
        int maxSum = A[0]; // sum of the array
        for (int i = 1; i < len; i++) {
            maxSum += A[i];
            if (A[i] > minSum) {
                minSum = A[i];
            }
        }

        int start = minSum;
        int end = maxSum;
        int target = start - 1;
        while (start <= end) {
            int check = (start + end) / 2;
            if (check(K, check, A)) {
                end = check - 1;
                target = check;
            } else {
                start = check + 1;
            }
        }

        if (target >= minSum) {
            return target;
        }

        return 0;
    }

    private boolean check(int K, int sum, int[] A) {
        int count = 0;
        int len = A.length;
        int currentSum = 0;
        for (int i = 0; i < len; i++) {
            if (currentSum + A[i] <= sum) {
                currentSum += A[i];
            } else {
                count += 1;
                currentSum = A[i];

            }

            if (i == len - 1) {
                count += 1;
            }

            if (count > K) {
                return false;
            }
        }
        return count <= K;
    }
}
