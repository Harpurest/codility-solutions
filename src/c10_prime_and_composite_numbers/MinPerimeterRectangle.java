package c10_prime_and_composite_numbers;

public class MinPerimeterRectangle {

    public static void main(String[] args) {
        MinPerimeterRectangle minPerimeterRectangle = new MinPerimeterRectangle();
        System.out.println(minPerimeterRectangle.solution(30));
    }

    public int solution(int N) {
        // a * b = N
        // (a + b) ^ 2 = (a - b)^2 - 4ab
        // => a - b min <=> a + b min
        long start = 1;
        long max = start;
        while (start * start < N) {
            if (N % start == 0) {
                max = start;
            }
            start += 1;
        }
        if (start * start == N) {
            max = start;
        }

        return Math.toIntExact(2 * (max + (N / max)));
    }
}
