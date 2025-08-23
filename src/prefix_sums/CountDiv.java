package prefix_sums;

public class CountDiv {
    public static void main(String[] args) {
        CountDiv countDiv = new CountDiv();
        System.out.println(countDiv.solution(6, 11, 2));
    }

    public int solution(int A, int B, int K) {
        int start = A % K == 0 ? A : A + (K - (A % K));
        int end = B % K == 0 ? B : B - (B % K);

        return (end - start) / K + 1;
    }
}
