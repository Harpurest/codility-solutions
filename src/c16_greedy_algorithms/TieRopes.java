package c16_greedy_algorithms;

public class TieRopes {

    public static void main(String[] args) {
        TieRopes tieRopes = new TieRopes();
        int res;

        res = tieRopes.solution(4, new int[] {1, 2, 3, 4, 1, 1, 3});
        System.out.println(res);
    }

    public int solution(int K, int[] A) {
        int len = A.length;
        int count = 0;
        int currentSum = 0;
        for (int i = 0; i < len; i++) {
            currentSum += A[i];
            if (currentSum >= K) {
                count += 1;
                currentSum = 0;
            }
        }
        return count;
    }
}
