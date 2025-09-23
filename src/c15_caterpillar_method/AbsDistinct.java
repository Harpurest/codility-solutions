package c15_caterpillar_method;

public class AbsDistinct {

    public static void main(String[] args) {
        AbsDistinct absDistinct = new AbsDistinct();
        int res;
        res = absDistinct.solution(new int[] {-5, -3, -1, 0, 3, 6});
        System.out.println(res);

        res = absDistinct.solution(new int[] {-2147483648, -1, 0, 1});
        System.out.println(res);
    }

    public int solution(int[] A) {
        int len = A.length;
        int count = 0;

        int start = 0;
        int end = len - 1;
        if (A[start] == A[end]) {
            return 1;
        }
        while (start <= end) {
            if (Math.abs(Long.valueOf(A[start])) == Math.abs(Long.valueOf(A[end]))) {
                while (start < len - 1 && A[start + 1] == A[start]) {
                    start += 1;
                }
                start += 1;
                while (end > 0 && A[end - 1] == A[end]) {
                    end -= 1;
                }
                end -=1;
                count += 1;
            } else {
                if (Math.abs(Long.valueOf(A[start])) < Math.abs(Long.valueOf(A[end]))) {
                    while (end > 0 && A[end - 1] == A[end]) {
                        end -= 1;
                    }
                    end -= 1;
                    count += 1;
                } else {
                    // Math.abs(A[start]) > Math.abs(A[end])
                    while (start < len - 1 && A[start + 1] == A[start]) {
                        start += 1;
                    }
                    start += 1;
                    count += 1;
                }
            }
        }
        return count;
    }
}
