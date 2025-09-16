package c12_euclidean_algorithm;

public class ChocolatesByNumbers {

    public static void main(String[] args) {
        ChocolatesByNumbers chocolatesByNumbers = new ChocolatesByNumbers();
        System.out.println(chocolatesByNumbers.solution(10,4));
    }

    public int solution(int N, int M) {
        int bcd = bcd(N,M);
        return N/bcd;
    }

    private int bcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return bcd(b, a % b);
        }
    }
}
