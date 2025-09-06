package prime_and_composite_numbers;

public class CountFactors {

    public static void main(String[] args) {
        CountFactors countFactors = new CountFactors();
        System.out.println(countFactors.solution(25));
    }

    public int solution(int N) {
        int count = 0;
        long start = 1;
        while (start * start < N) {
            if (N % start == 0) {
                count += 2;
            }
            start += 1;
        }
        if (start * start == N) {
            count += 1;
        }

        return count;
    }
}
